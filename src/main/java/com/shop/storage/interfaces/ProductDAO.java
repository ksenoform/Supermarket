package com.shop.storage.interfaces;

import com.shop.model.Product;

import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface ProductDAO {
    public List<Product> getListOfAllProduct();
    public void writeProductToBase(Product product);
}
