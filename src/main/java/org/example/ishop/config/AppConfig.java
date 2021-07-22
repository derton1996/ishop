package org.example.ishop.config;

import org.example.ishop.entities.StrandElectro;
import org.example.ishop.entities.Sale;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

@Configuration
@Import({AppInitializer.class})
@ComponentScan(basePackages = "org.example.ishop")
public class AppConfig {

//    @Bean
//    public SessionFactory sessionFactory() {
//        return new org.hibernate.cfg.Configuration()
//                .configure("hibernate/hibernate.cfg.xml")
//                .addAnnotatedClass(StrandElectro.class)
//                .addAnnotatedClass(Sale.class)
//                .buildSessionFactory();
//    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }

}
