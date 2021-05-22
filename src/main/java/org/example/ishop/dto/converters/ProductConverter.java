package org.example.ishop.dto.converters;

import org.example.ishop.dto.ProductDTO;
import org.example.ishop.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<Product, ProductDTO> {

    public Product dtoToEntity(ProductDTO dto) {
        Product entity = new Product(dto.getId());
        entity.setGauge(dto.getGauge());
        entity.setCountryOrigin(dto.getCountryOrigin());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public ProductDTO entityToDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setGauge(entity.getGauge());
        dto.setCountryOrigin(entity.getCountryOrigin());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}
