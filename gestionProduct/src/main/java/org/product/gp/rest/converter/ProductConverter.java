package org.product.gp.rest.converter;

import org.product.gp.domains.Product;
import org.product.gp.rest.provided.vo.ProductVo;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product toBean(ProductVo vo) {
        Product bean = new Product();
        if (vo != null) {
            if (vo.getUuid() != null)
                bean.setUuid(vo.getUuid());
            if (vo.getName() != null)
                bean.setName(vo.getName());
            if (vo.getDescription() != null)
                bean.setDescription(vo.getDescription());
            if (vo.getQuantity() != null)
                bean.setQuantity(Integer.parseInt(vo.getQuantity()));
            if (vo.getPrice() != null)
                bean.setPrice(Double.parseDouble(vo.getPrice()));
            if (vo.getRef() != null)
                bean.setRef(vo.getRef());
            if (vo.getIdStock() != null)
                bean.setIdStock(Integer.valueOf(vo.getIdStock()));
        }
        return bean;
    }

    public ProductVo toVo(Product bean) {
        ProductVo vo = new ProductVo();
        if (vo != null) {
            if (bean.getUuid() != null)
                vo.setUuid(bean.getUuid());
            if (bean.getName() != null)
                vo.setName(bean.getName());
            if (bean.getDescription() != null)
                vo.setDescription(bean.getDescription());
            if (bean.getQuantity() >= 0)
                vo.setQuantity(Integer.toString(bean.getQuantity()));
            if (bean.getPrice() != null)
                vo.setPrice(bean.getPrice().toString());
            if (bean.getRef() != null)
                vo.setRef(bean.getRef());
            // to do check stock
            //if (bean.getIdStock() != 0)
            vo.setIdStock(Integer.toString(bean.getIdStock()));
        }
        return vo;
    }
}
