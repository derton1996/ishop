package org.example.ishop.services.sale;

import org.example.ishop.database.sale.SaleRepository;
import org.example.ishop.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@PropertySource(value = "classpath:application.properties")
public class SaleServiceImpl implements SaleService {

    @Value("${images.folder}")
    public String IMAGES_FOLDER;

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
    public void save(Sale sale, MultipartFile image) {
        try {
            saveImage(sale, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        saleRepository.save(sale);
    }

    public void update(Sale sale, MultipartFile image) {
        try {
            Files.deleteIfExists(Paths.get(IMAGES_FOLDER + saleRepository.findById(sale.getId()).getImage()));
            saveImage(sale, image);
            saleRepository.update(sale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            Files.deleteIfExists(Paths.get(IMAGES_FOLDER + saleRepository.findById(id).getImage()));
            saleRepository.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImage(Sale sale, MultipartFile image) throws IOException {
        File dir = new File(IMAGES_FOLDER + sale.getImage());
        if (!dir.exists()) dir.mkdirs();
        sale.setImage(sale.getImage() + sale.getId() + "_" + image.getOriginalFilename());
        File targetFile = new File(IMAGES_FOLDER + sale.getImage());
        OutputStream outStream = new FileOutputStream(targetFile);
        byte[] buffer = image.getBytes();
        outStream.write(buffer);
        outStream.close();
    }
}
