package com.example.demo.service;


import com.example.demo.Exception.ApiOrderException;
import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemService orderItemService;
    public Order save(Order order) throws ApiOrderException {
        if (order.getTotalPaye()>order.getTotalPrice())
            throw new ApiOrderException("Can't save order with total pay greater than total price");
        order.setCreatedAt(LocalDateTime.now());
        order =  orderRepository.save(order);
        Order finalOrder = order;
        order.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(finalOrder);
            orderItemService.save(orderItem);
        });
        return order;

    }


    public Order findByName(String name) {
        return orderRepository.findByName(name);
    }

    public boolean existsByName(String name) {
        return orderRepository.existsByName(name);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
