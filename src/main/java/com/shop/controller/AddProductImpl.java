package com.shop.controller;

import com.shop.controller.interfaces.AddProduct;
import com.shop.controller.validators.ProductValidator;
import com.shop.domain.Product;
import com.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Robert Szczygielski on 2016-01-26.
 */
@Controller
@RequestMapping("addProduct/")
public class AddProductImpl implements AddProduct {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductValidator productValidator;

    @Override
    @RequestMapping(value = "contribute", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("addProduct/contribute", "productForm", new Product());
    }

    @Override
    @RequestMapping(value = "contribute",
            method = RequestMethod.POST,
            params = "Submit")
    public String saveInDataBase(@ModelAttribute("productForm") @Validated Product product,
                                 BindingResult bindingResult,
                                 ModelMap modelMap) {
        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors() || product == null) {
            return "addProduct/contribute";
        }

        productService.writeProductToBase(product);
        prepareViewWithAddingProduct(product, modelMap);
        modelMap.addAttribute("productForm", new Product());

        return "addProduct/contribute";
    }

    @Override
    @RequestMapping(value = {"contribute", "inventory"},
            method = RequestMethod.POST,
            params = "MainView")
    public String getRequestForMainView() {
        return "redirect:/";
    }

    private void prepareViewWithAddingProduct(Product product, ModelMap modelMap) {
        modelMap.addAttribute("product_id",
                buildRowWithProductDisplayedOnPage("ID: ",
                        product.getId().toString()));

        modelMap.addAttribute("product_name",
                buildRowWithProductDisplayedOnPage("Name: ",
                        product.getName()));

        modelMap.addAttribute("product_netPrice",
                buildRowWithProductDisplayedOnPage("Net price: ",
                        product.getNetPrice().toString()));

        modelMap.addAttribute("product_tax",
                buildRowWithProductDisplayedOnPage("Tax: ",
                        product.getTax().toString()));

        modelMap.addAttribute("product_totalPrice",
                buildRowWithProductDisplayedOnPage("Total Price: ",
                        product.getTotalPrice().toString()));
    }

    private String buildRowWithProductDisplayedOnPage(String name, String dataToDisplay) {
        String prefix = "<tr><td><h4>";
        String middle = "</h4></td><td>";
        String suffix = "</td></tr>";

        return prefix +
                name +
                middle +
                dataToDisplay +
                suffix;
    }
}
