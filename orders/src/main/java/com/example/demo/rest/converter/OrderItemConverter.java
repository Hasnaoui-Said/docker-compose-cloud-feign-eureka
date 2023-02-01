package com.example.demo.rest.converter;

import com.example.demo.domain.OrderItem;
import com.example.demo.rest.vo.OrderItemVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrderItemConverter {

    public OrderItem toBean(OrderItemVo vo) {
        OrderItem bean = new OrderItem();
        if (vo != null) {
            if (vo.getPrice() != null)
                bean.setPrice(Double.parseDouble(vo.getPrice()));
            if (vo.getQuantity() != null)
                bean.setQuantity(Integer.parseInt(vo.getQuantity()));
            if (vo.getQuantity() != null)
                bean.setRefProduct(vo.getRefProduct());
        }
        return bean;
    }

    public OrderItemVo toVo(OrderItem bean) {
        OrderItemVo vo = new OrderItemVo();
        if (bean != null) {
            if (bean.getPrice() != null)
                vo.setPrice(Double.toString(bean.getPrice()));
            if (bean.getQuantity() != null)
                vo.setQuantity(bean.getQuantity().toString());
            if (bean.getQuantity() != null)
                vo.setRefProduct(bean.getRefProduct());
        }
        return vo;
    }

    public Set<OrderItemVo> toVos(List<OrderItem> beans) {
        Set<OrderItemVo> vos = new HashSet<>();
        beans.forEach(orderItem -> vos.add(this.toVo(orderItem)));
        return vos;
    }
    public Set<OrderItem> toBeans(Set<OrderItemVo> vos) {
        Set<OrderItem> beans = new HashSet<>();
        vos.forEach(orderItemVo -> beans.add(this.toBean(orderItemVo)));
        return beans;
    }


}
