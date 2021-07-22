package org.example.ishop.database.product;

import org.example.ishop.dto.FilterStrandDTO;
import org.example.ishop.entities.StrandElectro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

    @Override
    public List<StrandElectro> filter(FilterStrandDTO filter) {
        Session session = sessionFactory.getCurrentSession();
        try {
            StringBuilder hql = new StringBuilder("FROM StrandElectro WHERE ");

            if (!filter.getPriceFrom().isEmpty()) {
                hql.append("price >= '" + filter.getPriceFrom() + "' AND ");
            }
            if (!filter.getPriceTo().isEmpty()) {
                hql.append("price <= '" + filter.getPriceTo() + "' AND ");
            }
            if (!filter.getBrand().isEmpty()) {
                hql.append("brand = '" + filter.getBrand() + "' AND");
            }

            session.beginTransaction();
            String h = hql.toString().trim().substring(0, hql.length() - 4);
            List<StrandElectro> res = session.createQuery(h).getResultList();
            session.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    private StrandElectro merge(StrandElectro entity, StrandElectro dto) {
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setBrand(dto.getBrand());
        entity.setGauge(dto.getGauge());
        entity.setCountryOrigin(dto.getCountryOrigin());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        return entity;
    }
}
