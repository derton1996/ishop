package org.example.ishop.services.sale;

import org.example.ishop.database.sale.SaleRepository;
import org.example.ishop.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale findById(String id) {
        return saleRepository.findById(id);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public void save(Sale Sale) {
        saleRepository.save(Sale);
    }

    public void update(Sale Sale) {
        saleRepository.update(Sale);
    }

    @Override
    public void deleteById(String id) {
        saleRepository.deleteById(id);
    }
}
