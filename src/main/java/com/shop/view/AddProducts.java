package com.shop.view;

import com.shop.storage.Warehouse;
import com.shop.support.ConsoleReader;
import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;

/**
 * Created by RSzczygielski on 2016-01-18.
 */
public class AddProducts implements Commands {
    private Warehouse warehouse;

    public AddProducts(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void execute() {
        Product product = createProduct();
        String amount = getAmountValue();

        warehouse.addProductToWarehouse(product, amount);
    }

    private Product createProduct() {
        System.out.println("Product id: ");
        String productId = ConsoleReader.readData();

        System.out.println("Product name: ");
        String productName = ConsoleReader.readData();

        System.out.println("Product net price: ");
        String productNetPrice = ConsoleReader.readData();

        System.out.println("Product tax: ");
        String productTax = ConsoleReader.readData();

        Product product = new ProductBuilderImpl()
                .setId(productId)
                .setName(productName)
                .setNetPrice(productNetPrice)
                .setTax(productTax)
                .build();

        return product;
    }

    private String getAmountValue() {
        System.out.println("Set quantity of the product: ");
        String result = ConsoleReader.readData();

        return result;
    }
}