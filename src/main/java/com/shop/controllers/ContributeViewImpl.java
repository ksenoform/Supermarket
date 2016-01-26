package com.shop.controllers;

import com.shop.wares.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RSzczygielski on 2016-01-26.
 */
@Controller
@RequestMapping("addProduct/")
public class ContributeViewImpl implements ContributeView {

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
     public ModelAndView showProductForm() {
        return new ModelAndView("addProduct/contribute", "productForm", new ProductImpl());
    }

    @Override
    @RequestMapping(value = "contribute", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute ProductImpl product, ModelMap modelMap) {
        modelMap.addAttribute("product_id", product.getId());
        modelMap.addAttribute("product_name", product.getName());
        modelMap.addAttribute("product_netPrice", product.getNetPrice());
        modelMap.addAttribute("product_tax", product.getTax());
        modelMap.addAttribute("product_totalPrice", product.getTotalPrice());

        return "addProduct/contribute";
    }
}
