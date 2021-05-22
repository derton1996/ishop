package org.example.ishop.database.sale;

import org.example.ishop.entities.Sale;
import org.example.ishop.entities.Sale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository{
    
    private final SessionFactory sessionFactory;

    @Autowired
    public SaleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Sale findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Sale Sale = session.get(Sale.class, id);
            session.getTransaction().commit();
            return Sale;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Sale> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Sale> SaleList = session.createQuery("from Sale").getResultList();
            session.getTransaction().commit();
            return SaleList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(Sale Sale) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(Sale);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Sale Sale) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Sale dbSale = session.get(Sale.class, Sale.getId());
            merge(dbSale, Sale);
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
            Sale Sale = session.get(Sale.class, id);
            session.delete(Sale);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private Sale merge(Sale dbSale, Sale dtoSale) {
        dbSale.setDescription(dtoSale.getDescription());
        return dbSale;
    }
}
