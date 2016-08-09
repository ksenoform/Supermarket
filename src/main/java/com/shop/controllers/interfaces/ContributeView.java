package com.shop.controllers.interfaces;

import com.shop.storage.implementations.ProductImpl;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RSzczygielski on 2016-01-26.
 */
public interface ContributeView {
    public ModelAndView showProductForm();
    public String addProduct(ProductImpl product, BindingResult bindingResult, ModelMap modelMap);
    public String getRequestForMainView();
}
