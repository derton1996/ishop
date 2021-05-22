package org.example.ishop.database.sale;

import org.example.ishop.entities.Sale;

import java.util.List;

public interface SaleRepository {

    Sale findById(String id);

    List<Sale> findAll();

    void save(Sale Sale);

    void update(Sale Sale);

    void deleteById(String id);

}
