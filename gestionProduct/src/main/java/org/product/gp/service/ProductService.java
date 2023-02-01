package org.product.gp.service;

import org.product.gp.domains.Product;
import org.product.gp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findByUuid(UUID uuid) {
        return productRepository.findByUuid(uuid);
    }
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public int deleteByUuid(UUID uuid) {
        return productRepository.deleteByUuid(uuid);
    }

    public boolean existsByUuid(UUID uuid) {
        return productRepository.existsByUuid(uuid);
    }

    public Product save(@Valid Product product) {
        System.out.println(this.existsByUuid(product.getUuid()));
        if (this.existsByUuid(product.getUuid()))
            return null;
        if (this.existsByName(product.getName()))
            return null;
        product.setUuid(UUID.randomUUID());
        System.out.println("2");
        System.out.println(product);
        Product p = productRepository.save(product);
        return p;
    }

    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
