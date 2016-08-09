package com.shop.support;

import com.shop.storage.interfaces.Product;

import java.util.List;

/**
 * Created by RSzczygielski on 04.02.16.
 */
public interface DatabaseConnector {
    public void writeToDatabase(Product product);
    public List<Product> readFromDatabase();
}
