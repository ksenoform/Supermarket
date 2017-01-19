package com.shop.controller.interfaces;

import com.shop.domain.Product;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Robert Szczygielski on 2016-01-26.
 */
public interface AddProduct {
    ModelAndView showForm();
    String saveInDataBase(Product product, BindingResult bindingResult, ModelMap modelMap);
    String getRequestForMainView();
}
