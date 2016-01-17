package com.shop.storage;

import com.shop.Product;

import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface Warehouse {
    public List<Product> getAllProduct();
    public Product getProductByID(String id);
    public Product getProductByName(String name);
    public void addProduct(Product product);
}
