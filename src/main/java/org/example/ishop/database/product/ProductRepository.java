package org.example.ishop.database.product;

import org.example.ishop.dto.FilterStrandDTO;
import org.example.ishop.entities.StrandElectro;

import java.util.List;

public interface ProductRepository {

    StrandElectro findById(String id);

    List<StrandElectro> findAll();

    void save(StrandElectro strandElectro);

    void update(StrandElectro strandElectro);

    void deleteById(String id);

    List<StrandElectro> filter(FilterStrandDTO filter);

}
