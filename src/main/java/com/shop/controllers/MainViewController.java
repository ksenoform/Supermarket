package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by RSzczygielski on 2016-01-25.
 */
@Controller
public class MainViewController {
    @RequestMapping("/")
    public String ShowMainView(Model model) {
        model.addAttribute("toShow", "Warehouse view");

        return "index";
    }
}
