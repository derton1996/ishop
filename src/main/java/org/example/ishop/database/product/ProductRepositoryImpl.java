package org.example.ishop.database.product;

import org.example.ishop.entities.StrandElectro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StrandElectro findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            StrandElectro strandElectro = session.get(StrandElectro.class, id);
            session.getTransaction().commit();
            return strandElectro;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<StrandElectro> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<StrandElectro> strandElectroList = session.createQuery("from StrandElectro").getResultList();
            session.getTransaction().commit();
            return strandElectroList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void save(StrandElectro strandElectro) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(strandElectro);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(StrandElectro strandElectro) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            StrandElectro dbStrandElectro = session.get(StrandElectro.class, strandElectro.getId());
            merge(dbStrandElectro, strandElectro);
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
            StrandElectro strandElectro = session.get(StrandElectro.class, id);
            session.delete(strandElectro);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private StrandElectro merge(StrandElectro entity, StrandElectro dto) {
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setGauge(dto.getGauge());
        entity.setCountryOrigin(dto.getCountryOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        return entity;
    }
}
