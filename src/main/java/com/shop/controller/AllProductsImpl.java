package com.shop.controller;

import com.shop.controller.interfaces.AllProducts;
import com.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Robert Szczygielski on 2016-01-28.
 */
@Controller
@RequestMapping("/allProducts")
public class AllProductsImpl implements AllProducts {
    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public String getRequestFromAllProductsButton(ModelMap modelMap) {
        String message = "<br><div style='text-align:center;'> All product in warehouse </div><br><br>";

        modelMap.addAttribute("showInventory", message);
        modelMap.addAttribute("products", productService.getListOfAllProduct());

        return "allProducts/inventory";
    }

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.POST, params = "MainView")
    public String getRequestForMainView() {
        return "redirect:/";
    }
}
