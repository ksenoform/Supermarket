package com.shop.support;

import com.shop.wares.Product;

import java.util.Map;

/**
 * Created by RSzczygielski on 04.02.16.
 */
public interface DatabaseConnector {
    public void writeToDatabase(Product product);
    public Map<Product, Integer> readFromDatabase();
}
