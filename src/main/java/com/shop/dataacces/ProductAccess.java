package com.shop.dataacces;

import com.shop.model.Product;

import java.util.List;

/**
 * Created by RSzczygielski on 04.02.16.
 */
public interface ProductAccess {
    void writeProductToBase(Product product);
    List<Product> getListOfAllProduct();
    Product getProductById(Integer id);
    Product getProductByName(String name);
}
