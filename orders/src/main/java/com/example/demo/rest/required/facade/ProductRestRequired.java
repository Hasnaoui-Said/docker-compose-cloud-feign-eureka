package com.example.demo.rest.required.facade;

import com.example.demo.rest.required.vo.ProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "microservice-stock-product-v1", url = "http://localhost:9091/api/v1/product")
public interface ProductRestRequired {
    @RequestMapping(method = RequestMethod.GET, value = "/uuid/{uuid}", produces = "application/json")
    ProductVo findByUuid(@PathVariable UUID uuid);
}

