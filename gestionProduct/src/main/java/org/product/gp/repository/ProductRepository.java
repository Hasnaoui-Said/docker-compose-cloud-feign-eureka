package org.product.gp.repository;

import org.product.gp.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByUuid(UUID uuid);

    int deleteByUuid(UUID uuid);

    boolean existsByUuid(UUID uuid);

    Product findByName(String name);
    boolean existsByName(String name);
}
