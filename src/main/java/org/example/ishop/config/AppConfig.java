package org.example.ishop.config;

import org.example.ishop.entities.Product;
import org.example.ishop.entities.Sale;
import org.hibernate.SessionFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.MultipartConfigElement;

@Configuration
@Import({AppInitializer.class})
@ComponentScan(basePackages = "org.example.ishop")
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Sale.class)
                .buildSessionFactory();
    }

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

//    @Value("${driverClassName}")
//    String driverClassName;
//    @Value("${url}")
//    String url;
//    @Value("${username}")
//    String username;
//    @Value("${password}")
//    String password;
//
//    public String getDriverClassName() {
//        return driverClassName;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        try {
//            BasicDataSource dataSource = new BasicDataSource();
//            dataSource.setDriverClassName(driverClassName);
//            dataSource.setUrl(url);
//            dataSource.setUsername(username);
//            dataSource.setPassword(password);
//            return dataSource;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager(entityManagerFactory());
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public Properties hibernateProperties() {
//        Properties hibernateProp = new Properties();
//        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        hibernateProp.put("hibernate.format_sql", true);
//        hibernateProp.put("hibernate.use_sql_comments", true);
//        hibernateProp.put("hibernate.show_sql", true);
//        hibernateProp.put("hibernate.max_fetch_depth", 3);
//        hibernateProp.put("hibernate.jdbc.batch_size", 10);
//        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
//        return hibernateProp;
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setPackagesToScan("org.example.ishop");
//        factoryBean.setDataSource(dataSource());
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        factoryBean.setJpaProperties(hibernateProperties());
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        factoryBean.afterPropertiesSet();
//        return factoryBean.getNativeEntityManagerFactory();
//    }

}
