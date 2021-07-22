package org.example.ishop.database.product;

import org.example.ishop.dto.FilterStrandDTO;
import org.example.ishop.entities.StrandElectro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Override
    public StrandElectro findById(String id) {
        return null;
    }

    @Override
    public List<StrandElectro> findAll() {
        return null;
    }

    @Override
    public void save(StrandElectro strandElectro) {

    }

    @Override
    public void update(StrandElectro strandElectro) {
    }


    @Override
    public void deleteById(String id) {
    }

    @Override
    public List<StrandElectro> filter(FilterStrandDTO filter) {
        return null;
    }

    private StrandElectro merge(StrandElectro entity, StrandElectro dto) {
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setBrand(dto.getBrand());
        entity.setGauge(dto.getGauge());
        entity.setCountryOrigin(dto.getCountryOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        return entity;
    }
}
