package com.shop.controllers;

import com.shop.storage.Warehouse;
import com.shop.storage.WarehouseImpl;
import com.shop.wares.ProductBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by RSzczygielski on 2016-01-28.
 */
@Controller
@RequestMapping("/allProducts")
public class AvailabilityImpl implements Availability {
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Autowired
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public String getRequestFromAllProductsButton(ModelMap modelMap) {
        String message = "<br><div style='text-align:center;'> All product in warehouse </div><br><br>";
        warehouse.addProductToWarehouse(new ProductBuilderImpl().build());

        modelMap.addAttribute("showInventory", message);
        modelMap.addAttribute("products", warehouse.getAllProduct());

        return "allProducts/inventory";
    }


}
