package com.shop.controller.interfaces;

import org.springframework.ui.ModelMap;

/**
 * Created by Robert Szczygielski on 2016-01-28.
 */
public interface AllProducts {
    String getRequestFromAllProductsButton(ModelMap modelMap);
    String getRequestForMainView();
}
