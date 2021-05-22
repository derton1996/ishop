package org.example.ishop.database.product;

import org.example.ishop.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Product> productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Product dbProduct = session.get(Product.class, product.getId());
            merge(dbProduct, product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    @Override
    public void deleteById(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Product merge(Product dbProduct, Product dtoProduct) {
        dbProduct.setGauge(dtoProduct.getGauge());
        dbProduct.setCountryOrigin(dtoProduct.getCountryOrigin());
        dbProduct.setDescription(dtoProduct.getDescription());
        return dbProduct;
    }
}
