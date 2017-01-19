package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Robert Szczygielski on 2016-01-25.
 */
@Controller
@RequestMapping("/")
public class MainViewController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showMainView() {
        String message = "<br><div style='text-align:center'> Warehouse view </div><br><br>";

        return new ModelAndView("index", "toShow", message);
    }

    @RequestMapping(method = RequestMethod.POST, params = "AllProducts")
    public String getRequestFromAllProductsButton() {
        return "redirect:/allProducts/inventory";
    }

    @RequestMapping(method = RequestMethod.POST, params = "AddProducts")
    public String getRequestFromAddProductsButton() {
        return "redirect:/addProduct/contribute";
    }
}
