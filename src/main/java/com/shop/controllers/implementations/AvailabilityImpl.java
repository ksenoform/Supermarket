package com.shop.controllers.implementations;

import com.shop.controllers.interfaces.Availability;
import com.shop.support.DatabaseConnector;
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
    @Autowired
    private DatabaseConnector databaseConnector;

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public String getRequestFromAllProductsButton(ModelMap modelMap) {
        String message = "<br><div style='text-align:center;'> All product in warehouse </div><br><br>";


        modelMap.addAttribute("showInventory", message);
        modelMap.addAttribute("products", databaseConnector.readFromDatabase());

        return "allProducts/inventory";
    }

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.POST, params = "MainView")
    public String getRequestForMainView() {
        return "redirect:/";
    }
}
