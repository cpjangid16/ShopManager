package com.shopmanager.ShopManager.Service;

import com.shopmanager.ShopManager.Entity.Product;
import com.shopmanager.ShopManager.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

    public List<Product> all() {return repo.findAll();}
    public Product one(Long id) {return repo.findById(id).orElseThrow();}
    public Product save(Product P) {return repo.save(P);}
    public void delete(Long id) {repo.deleteById(id);}

}
