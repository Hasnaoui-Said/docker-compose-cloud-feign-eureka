package com.example.demo.rest.vo;

import com.example.demo.domain.OrderItem;

import java.util.HashSet;
import java.util.Set;

public class OrderVo {
    private String name;
    private String totalPrice;
    private String totalPaye;
    private Set<OrderItemVo> orderItems = new HashSet<>();

    public Set<OrderItemVo> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemVo> orderItems) {
        this.orderItems = orderItems;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(String totalPaye) {
        this.totalPaye = totalPaye;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "name='" + name + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", totalPaye='" + totalPaye + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
