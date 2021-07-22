package org.example.ishop.database.sale;

import org.example.ishop.entities.Sale;
import org.example.ishop.entities.Sale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository{

    @Override
    public Sale findById(String id) {
        return null;
    }

    @Override
    public List<Sale> findAll() {
        return null;
    }

    @Override
    public void save(Sale Sale) {
    }

    @Override
    public void update(Sale Sale) {

    }


    @Override
    public void deleteById(String id) {

    }

    private Sale merge(Sale dbSale, Sale dtoSale) {
        dbSale.setTitle(dtoSale.getTitle());
        dbSale.setDescription(dtoSale.getDescription());
        dbSale.setImage(dtoSale.getImage());
        return dbSale;
    }
}
