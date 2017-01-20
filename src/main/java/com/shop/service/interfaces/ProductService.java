package com.shop.service.interfaces;

import com.shop.domain.Product;

import java.util.List;

/**
 * Created by Robert Szczygielski on 17.01.16.
 */
public interface ProductService {
    void writeProductToBase(Product product);
    List getAllProduct();
    Product getProductByID(Integer id);
    Product getProductByName(String name);
    void putNewProductToWarehouse(Product product);
    void addItemToProduct(Integer productId, Integer item);
    void subItemFromProduct(Integer productId, Integer item);
}
