package com.shop.support;

import com.shop.storage.interfaces.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RSzczygielski on 03.02.16.
 */
@Repository
@Transactional
public class DatabaseConnectorImpl implements DatabaseConnector{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void writeToDatabase(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> readFromDatabase() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from ProductImpl").list();
    }
}
