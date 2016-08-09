package com.shop.storage.interfaces;

import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface Warehouse {
    public List<Product> getAllProduct();
    public Product getProductByID(String id);
    public Product getProductByName(String name);
    public void pubNewProductToWarehouse(Product product);
    public void addProductToWarehouse(Product product, Integer amount);
    public void subtractProductFromWarehouse(Product product, Integer amount);
}
