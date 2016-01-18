package com.shop.view;

import com.shop.storage.Warehouse;

/**
 * Created by RSzczygielski on 2016-01-18.
 */
public class ShowProductsMenu implements Commands {
    Warehouse warehouse;

    public ShowProductsMenu(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void execute() {
        System.out.println(warehouse);
    }
}
