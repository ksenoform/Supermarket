package com.shop.storage.interfaces;

import com.shop.model.Product;

import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface Warehouse {
    List<Product> getAllProduct();
    Product getProductByID(Integer id);
    Product getProductByName(String name);
    void putNewProductToWarehouse(Product product);
    void addItemToProduct(Integer productId, Integer item);
    void subItemFromProduct(Integer productId, Integer item);
}
