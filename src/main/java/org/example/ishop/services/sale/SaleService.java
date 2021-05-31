package org.example.ishop.services.sale;

import org.example.ishop.entities.Sale;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SaleService {

    Sale findById(String id);

    List<Sale> findAll();

    void save(Sale sale, MultipartFile image);

    void update(Sale sale, MultipartFile image);

    void deleteById(String id);
    
}
