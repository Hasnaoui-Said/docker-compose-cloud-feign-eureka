package com.example.demo.rest.provided.facade;


import com.example.demo.Exception.ApiOrderException;
import com.example.demo.domain.Order;
import com.example.demo.rest.converter.OrderConverter;
import com.example.demo.rest.vo.OrderVo;
import com.example.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@Api("Getsion des commandes")
public class OrderResource {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderConverter orderConverter;

    @PostMapping("/")
    @ApiOperation("save order")
    @ResponseBody
    public OrderVo save(@RequestBody @Valid OrderVo orderVo) throws ApiOrderException {
        Order order = orderConverter.toBean(orderVo);
        Order save = orderService.save(order);
        OrderVo vo = orderConverter.toVo(save);
        return vo;
    }

    @PostMapping("/name/{name}")
    @ApiOperation("find by name order")
    @ResponseBody
    public OrderVo findByName(@PathVariable String name) {
        Order byName = orderService.findByName(name);
        return orderConverter.toVo(byName);
    }

    @PostMapping("/exists/{name}")
    @ApiOperation("exists by name order")
    @ResponseBody
    public boolean existsByName(@PathVariable String name) {
        return orderService.existsByName(name);
    }

    @GetMapping("/")
    @ApiOperation("find all commande")
    public List<OrderVo> findAll() {
        List<OrderVo> orderVos = new ArrayList<>();

        List<Order> all = orderService.findAll();
        all.forEach(order -> orderVos.add(orderConverter.toVo(order)));
        return orderVos;
    }
}
