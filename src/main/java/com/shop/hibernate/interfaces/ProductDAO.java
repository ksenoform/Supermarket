package com.shop.hibernate.interfaces;

import com.shop.domain.Product;

import java.util.List;

/**
 * Created by Robert Szczygielski on 04.02.16.
 */
public interface ProductDAO {
    void writeProductToBase(Product product);
    List getListOfAllProduct();
    Product getProductById(Integer id);
    Product getProductByName(String name);
}
