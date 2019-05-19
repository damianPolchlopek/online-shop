package com.online.shop.project.dao;

import com.online.shop.project.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

        List<Product> products = theQuery.getResultList();

        return products;

    }

    @Override
    public Product findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Product product =
                currentSession.get(Product.class, theId);
        return product;
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

}
