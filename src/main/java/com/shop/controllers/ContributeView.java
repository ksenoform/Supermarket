package com.shop.controllers;

import com.shop.wares.ProductImpl;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RSzczygielski on 2016-01-26.
 */
public interface ContributeView {
    public ModelAndView showProductForm();
    public String addProduct(ProductImpl product, ModelMap modelMap);
}
