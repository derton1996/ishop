package org.example.ishop.services.product;

import org.example.ishop.entities.Product;

import java.util.List;

public interface ProductService {

    Product findById(String id);

    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void deleteById(String id);

}
