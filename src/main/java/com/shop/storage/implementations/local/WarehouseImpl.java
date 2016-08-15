package com.shop.storage.implementations.local;

import com.shop.dataacces.ProductAccess;
import com.shop.model.Product;
import com.shop.storage.interfaces.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImpl implements Warehouse {
    ProductAccess productAccess;

    @Autowired
    public void setProductAccess(ProductAccess productAccess) {
        this.productAccess = productAccess;
    }

    @Override
    public List<Product> getAllProduct()
    {
        List<Product> productList = productAccess.getListOfAllProduct();
        return productList.isEmpty()
                ? Collections.EMPTY_LIST
                : productList;
    }

    @Override
    public Product getProductByID(Integer id) {
        Product product = productAccess.getProductById(id);
        return product != null
                ? product
                : new ProductBuilderImpl().build();
    }

    @Override
    public Product getProductByName(String name) {
        Product product = productAccess.getProductByName(name);
        return product != null
                ? product
                : new ProductBuilderImpl().build();
    }

    @Override
    public void putNewProductToWarehouse(Product product) {
        productAccess.writeProductToBase(product);
    }

    @Override
    public void addItemToProduct(Integer productId, Integer item) {
        Product product = productAccess.getProductById(productId);
        item = new Integer(product.getItems() + item);
        product.setItems(item);
        productAccess.writeProductToBase(product);
    }

    @Override
    public void subItemFromProduct(Integer productId, Integer item) {
        Product product = productAccess.getProductById(productId);
        item = new Integer(product.getItems() - item);
        product.setItems(item);
        productAccess.writeProductToBase(product);
    }

    @Override
    public String toString() {
        StringBuilder dataWitchAmount = new StringBuilder();

        for (Product product : productAccess.getListOfAllProduct()) {
            dataWitchAmount.append(product);
            dataWitchAmount.append("\n");
        }

        return dataWitchAmount.toString();
    }
}