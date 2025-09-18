package com.shopmanager.ShopManager.Repository;

import com.shopmanager.ShopManager.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> id(long id);
}
