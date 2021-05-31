package org.example.ishop.dto.converters;

import org.example.ishop.dto.SaleDTO;
import org.example.ishop.entities.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter implements Converter<Sale, SaleDTO> {

    private static final String SALE_IMAGES_DIRECTORY = "images/sale/";

    @Override
    public Sale dtoToEntity(SaleDTO dto) {
        Sale sale = new Sale(dto.getId());
        sale.setTitle(dto.getTitle());
        sale.setDescription(dto.getDescription());
        sale.setImage(SALE_IMAGES_DIRECTORY);
        return sale;
    }

    @Override
    public SaleDTO entityToDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setId(sale.getId());
        saleDTO.setTitle(sale.getTitle());
        saleDTO.setDescription(sale.getDescription());
        saleDTO.setImage(sale.getImage());
        return saleDTO;
    }
}
