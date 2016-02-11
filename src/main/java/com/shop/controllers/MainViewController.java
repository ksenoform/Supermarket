package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RSzczygielski on 2016-01-25.
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
    public String getRequestFromAllProductsButtom() {
        return "redirect:/allProducts/inventory";
    }

    @RequestMapping(method = RequestMethod.POST, params = "AddProducts")
    public String getRequestFromAddProductsButtom() {
        return "redirect:/addProduct/inventory";
    }
}
