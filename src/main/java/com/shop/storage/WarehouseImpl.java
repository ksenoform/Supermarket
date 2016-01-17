package com.shop.storage;

import com.shop.wares.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImpl implements Warehouse {
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public Product getProductByID(String id) {
        for (Product product : productList) {
            String productId = product.getId();

            if (productId.equals(id)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : productList) {
            String productName = product.getName();

            if (productName.equals(name)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }
}
