package com.shop.dataacces;

import com.shop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RSzczygielski on 03.02.16.
 */
@Repository("databaseConnector")
@Transactional
public class ProductAccessImpl implements ProductAccess {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void writeProductToBase(Product product) {
        getSession().save(product);
    }

    @Override
    public List<Product> getListOfAllProduct() {
        String query = "FROM Product";
        return getSession().createQuery(query)
                            .list();
    }

    @Override
    public Product getProductById(Integer id) {
        String s = "select * from Product where entityId = :entityId";
        Query query = getSession().createSQLQuery(s)
                                    .addEntity(Product.class)
                                    .setParameter("entityId", id);
        return (Product) query.list()
                                .get(0);
    }

    @Override
    public Product getProductByName(String name) {
        String s = "select * from Product where name = :name";
        Query query = getSession().createSQLQuery(s)
                                    .addEntity(Product.class)
                                    .setParameter("name", name);
        return (Product) query.list()
                                .get(0);
    }
}
