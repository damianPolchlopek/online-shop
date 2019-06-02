package com.online.shop.project.dao;

import com.online.shop.project.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Product> theQuery =
                currentSession.createQuery("from Product", Product.class);
        return theQuery.getResultList();
    }

    @Override
    public Product findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Product.class, theId);
    }

    @Override
    public void save(Product theProduct) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theProduct);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery(
                "delete from Product where id=:productId");
        query.setParameter("productId", theId);
        query.executeUpdate();
    }

    @Override
    public List findByCategory(String cat) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Product> query = currentSession.createQuery(
                "from Product where category=:categoryName", Product.class);
        query.setParameter("categoryName", cat);
        return query.getResultList();
    }

    @Override
    public List findByName(String argument) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Product> query = currentSession.createQuery(
                "from Product where name=:name", Product.class);
        query.setParameter("name", argument);
        return query.getResultList();
    }

}