package com.shop.support;

import com.shop.wares.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Product, Integer> readFromDatabase() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> allProduct = session.createQuery("from ProductImpl").list();

        Map<Product, Integer> result = addAmountOfProduct(allProduct);

        return result;
    }

    private Map<Product, Integer> addAmountOfProduct(List<Product> allProduct) {
        if (allProduct.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<Product, Integer> toReturnWithAmount = new HashMap<Product, Integer>();

        for (Product product : allProduct) {
            Integer amount = getAmountFromDataBase(product);
            toReturnWithAmount.put(product, amount);
        }

        return toReturnWithAmount;
    }

    private Integer getAmountFromDataBase(Product product) {
        return 1;
    }

}
