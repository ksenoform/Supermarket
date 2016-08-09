package com.shop.storage.implementations;

import com.shop.storage.interfaces.Warehouse;
import com.shop.storage.interfaces.Product;

import java.util.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImpl implements Warehouse {
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getAllProduct()
    {
        return productList.isEmpty()
                ? Collections.EMPTY_LIST
                : productList;
    }

    @Override
    public Product getProductByID(String id) {
        for (Product product : productList) {
            String currentId = product.getId();

            if (currentId.equals(id)) {
                return product;
            }
        }

        return new ProductBuilderImpl().build();
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : productList) {
            String productName = product.getName();

            if (productName.equals(name)) {
                return product;
            }
        }

        return new ProductBuilderImpl().build();
    }

    @Override
    public void pubNewProductToWarehouse(Product product) {
        productList.add(product);
    }

    @Override
    public void addProductToWarehouse(Product product, Integer amount) {
        if (productList.contains(product)) {
            Integer index = productList.indexOf(product);
            amount += product.getItems();
            product.setItems(amount);

            productList.set(index, product);
        }
    }

    @Override
    public void subtractProductFromWarehouse(Product product, Integer amount) {
        if (productList.contains(product)) {
            Integer index = productList.indexOf(product);
            Integer oldAmount = product.getItems();
            Integer newAmount = oldAmount - amount;
            product.setItems(newAmount);

            productList.set(index, product);
        }
    }

    @Override
    public String toString() {
        StringBuilder dataWitchAmount = new StringBuilder();

        for (Product product : productList) {
            dataWitchAmount.append(product);
            dataWitchAmount.append("\n");
        }

        return dataWitchAmount.toString();
    }
}