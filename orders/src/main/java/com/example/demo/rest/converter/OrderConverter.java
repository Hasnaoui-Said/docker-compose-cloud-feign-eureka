package com.example.demo.rest.converter;

import com.example.demo.domain.Order;
import com.example.demo.rest.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    OrderItemConverter orderItemConverter;
    public Order toBean(OrderVo vo){
        Order bean = new Order();
        if (vo != null){
            if (vo.getName() != null)
                bean.setName(vo.getName());
            if (vo.getTotalPaye() != null)
                bean.setTotalPaye(Double.parseDouble(vo.getTotalPaye()));
            if (vo.getTotalPrice() != null)
                bean.setTotalPrice(Double.parseDouble(vo.getTotalPrice()));
        }
        bean.setOrderItems(orderItemConverter.toBeans(vo.getOrderItems()));
        return bean;
    }
    public OrderVo toVo(Order bean){
        OrderVo vo = new OrderVo();
        if (bean != null){
            if (bean.getName() != null)
                vo.setName(bean.getName());
            if (bean.getTotalPaye() != null)
                vo.setTotalPaye(bean.getTotalPaye().toString());
            if (bean.getTotalPrice() != null)
                vo.setTotalPrice(bean.getTotalPrice().toString());
        }
        return vo;
    }
}
