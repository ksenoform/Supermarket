package com.shop.controllers;

import org.springframework.ui.ModelMap;

/**
 * Created by RSzczygielski on 2016-01-28.
 */
public interface Availability {
    public String getRequestFromAllProductsButton(ModelMap modelMap);
    public String getRequestForMainView();
}
