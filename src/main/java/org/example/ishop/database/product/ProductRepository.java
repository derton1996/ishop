package org.example.ishop.database.product;

import org.example.ishop.entities.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(String id);

    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void deleteById(String id);

}
