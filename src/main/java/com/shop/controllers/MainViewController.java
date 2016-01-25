package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RSzczygielski on 2016-01-25.
 */
@Controller
public class MainViewController {
    @RequestMapping("/")
    public ModelAndView ShowMainView() {
        String message = "<br><div style='text-align:center;'> Warehouse view </div><br><br>";

        return new ModelAndView("index", "toShow", message);
    }
}
