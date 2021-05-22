package org.example.ishop.services.sale;

import org.example.ishop.entities.Sale;

import java.util.List;

public interface SaleService {

    Sale findById(String id);

    List<Sale> findAll();

    void save(Sale Sale);

    void update(Sale Sale);

    void deleteById(String id);
    
}
