package com.shop.support;

import com.shop.wares.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RSzczygielski on 03.02.16.
 */
@Repository
@Transactional
public class DatabaseConnector {
    @Autowired
    SessionFactory sessionFactory;

    public void writeToDatabase(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }
}
