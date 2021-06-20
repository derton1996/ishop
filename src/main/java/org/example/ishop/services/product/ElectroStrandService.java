package org.example.ishop.services.product;

import org.example.ishop.dto.FilterStrandDTO;
import org.example.ishop.entities.StrandElectro;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ElectroStrandService {

    StrandElectro findById(String id);

    List<StrandElectro> findAll();

    void save(StrandElectro strandElectro, MultipartFile image);

    void update(StrandElectro strandElectro, MultipartFile image);

    void deleteById(String id);

    List<StrandElectro> filter(FilterStrandDTO filter);

}
