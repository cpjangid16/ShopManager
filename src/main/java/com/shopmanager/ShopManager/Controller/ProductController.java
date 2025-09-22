package com.shopmanager.ShopManager.Controller;

import com.shopmanager.ShopManager.Entity.Product;
import com.shopmanager.ShopManager.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
//@CrossOrigin(origin="http://localhost:5173")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> all() { return service.all();}

    @GetMapping("/{id}")
    public Product one(@PathVariable Long id) {return service.one(id);}

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product add(@RequestBody Product p) { return service.save(p);}

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product update(@PathVariable Long id, @RequestBody Product p) { p.setId(id); return service.save(p);}

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {service.delete(id);}


}
