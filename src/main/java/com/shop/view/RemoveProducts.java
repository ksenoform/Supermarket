package com.shop.view;

import com.shop.storage.Warehouse;
import com.shop.support.ConsoleReader;
import com.shop.wares.Product;

/**
 * Created by RSzczygielski on 2016-01-19.
 */
public class RemoveProducts implements Commands {
    private Warehouse warehouse;

    public RemoveProducts(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void execute() {
        Product product = prepareProductWithOnlyIdToSubtract();
        String amount = getAmountValue();

        warehouse.subtractProductFromWarehouse(product, new Integer(amount));
    }

    private String getAmountValue() {
        System.out.println("How many products remove from stock: ");
        String amount = ConsoleReader.readData();

        return amount;
    }

    private Product prepareProductWithOnlyIdToSubtract() {
        System.out.println(warehouse);
        System.out.println("With product remove from stock (id): ");
        String idFromUse = ConsoleReader.readData();

        return warehouse.getProductByID(idFromUse);
    }
}
