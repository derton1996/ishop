package org.example.ishop.services.product;

import org.example.ishop.database.product.ProductRepository;
import org.example.ishop.entities.Sale;
import org.example.ishop.entities.StrandElectro;
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
import java.util.UUID;

@Service
@PropertySource(value = "classpath:application.properties")
public class ElectroStrandServiceImpl implements ElectroStrandService {

    @Value("${images.folder}")
    private String IMAGES_FOLDER;

    private static final String SALE_IMAGES_DIRECTORY = "/images/strand/electro/";
    
    ProductRepository productRepository;

    @Autowired
    public ElectroStrandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public StrandElectro findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<StrandElectro> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(StrandElectro strandElectro, MultipartFile image) {
        try {
            strandElectro.setId(UUID.randomUUID().toString());
            saveImage(strandElectro, image);
            productRepository.save(strandElectro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(StrandElectro strandElectro, MultipartFile image) {
        try {
            Files.deleteIfExists(Paths.get(IMAGES_FOLDER + productRepository.findById(strandElectro.getId()).getImage()));
            saveImage(strandElectro, image);
            productRepository.update(strandElectro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            Files.deleteIfExists(Paths.get(IMAGES_FOLDER + productRepository.findById(id).getImage()));
            productRepository.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveImage(StrandElectro strandElectro, MultipartFile image) throws IOException {
        File dir = new File(IMAGES_FOLDER + SALE_IMAGES_DIRECTORY);
        if (!dir.exists()) dir.mkdirs();
        strandElectro.setImage(SALE_IMAGES_DIRECTORY + strandElectro.getId() + "_" + image.getOriginalFilename());
        File targetFile = new File(IMAGES_FOLDER + strandElectro.getImage());
        OutputStream outStream = new FileOutputStream(targetFile);
        byte[] buffer = image.getBytes();
        outStream.write(buffer);
        outStream.close();
    }
}
