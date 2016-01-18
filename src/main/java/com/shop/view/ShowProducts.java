package com.shop.view;

import com.shop.storage.Warehouse;

/**
 * Created by RSzczygielski on 2016-01-18.
 */
public class ShowProducts implements Commands {
    Warehouse warehouse;

    public ShowProducts(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void execute() {
        System.out.println(warehouse);
    }
}
