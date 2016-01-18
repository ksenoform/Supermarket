package com.shop.storage;

import com.shop.wares.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface Warehouse {
    public Map<Product, Integer> getAllProduct();
    public Product getProductByID(String id);
    public Product getProductByName(String name);
    public void addProductToWarehouse(Product product, Integer amount);
    public void addProductToWarehouse(Product product, String amount);
    public void addProductToWarehouse(Product product);
    public void subtractProductFromWarehouse(Product product, Integer amount);
    public void subtractProductFromWarehouse(Product product, String amount);
    public void subtractProductFromWarehouse(Product product);

}
