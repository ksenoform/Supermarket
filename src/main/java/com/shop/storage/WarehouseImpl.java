package com.shop.storage;

import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImpl implements Warehouse {
    private Map<Product, Integer> productList = new HashMap<>();

    @Override
    public Map<Product, Integer> getAllProduct() {
        return productList;
    }

    @Override
    public Product getProductByID(String id) {
        for (Product product : productList.keySet()) {
            String productId = product.getId();

            if (productId.equals(id)) {
                return product;
            }
        }

        return new ProductBuilderImpl().build();
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : productList.keySet()) {
            String productName = product.getName();

            if (productName.equals(name)) {
                return product;
            }
        }

        return new ProductBuilderImpl().build();
    }

    @Override
    public void addProductToWarehouse(Product product, Integer amount) {
        if (productList.containsKey(product)) {
            amount += productList.get(product);
        }

        productList.put(product, amount);
    }

    @Override
    public void addProductToWarehouse(Product product, String amount) {
        Integer amountAsNumber = new Integer(amount);
        addProductToWarehouse(product, amountAsNumber);
    }

    @Override
    public void addProductToWarehouse(Product product) {
        addProductToWarehouse(product, new Integer(0));
    }

    @Override
    public void subtractProductFromWarehouse(Product product, Integer amount) {
        Integer oldAmount = productList.get(product);
        Integer newAmount = oldAmount - amount;

        addProductToWarehouse(product, newAmount);
    }

    @Override
    public void subtractProductFromWarehouse(Product product, String amount) {
        Integer amountAsNumber = new Integer(amount);
        subtractProductFromWarehouse(product, amountAsNumber);
    }

    @Override
    public void subtractProductFromWarehouse(Product product) {
        subtractProductFromWarehouse(product, new Integer(1));
    }

}
