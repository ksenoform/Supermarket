package com.shop.controllers.implementations;

import com.shop.controllers.interfaces.ContributeView;
import com.shop.model.Product;
import com.shop.storage.implementations.local.ProductDAOImpl;
import com.shop.storage.interfaces.ProductDAO;
import com.shop.dataacces.ProductAccess;
import com.shop.dataacces.ProductValidator;
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
 * Created by RSzczygielski on 2016-01-26.
 */
@Controller
@RequestMapping("addProduct/")
public class ContributeViewImpl implements ContributeView {
    @Autowired
    private ProductAccess productAccess;
    @Autowired
    private ProductValidator productValidator;

    @Override
    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public ModelAndView showProductForm() {
        return new ModelAndView("addProduct/contribute", "productForm", new Product());
    }

    @Override
    @RequestMapping(value = "contribute",
            method = RequestMethod.POST,
            params = "Submit")
    public String addProduct(@ModelAttribute("productForm") @Validated Product product,
                             BindingResult bindingResult,
                             ModelMap modelMap) {
        productValidator.validate(product, bindingResult);

        if (bindingResult.hasErrors() || product == null) {
            return "addProduct/contribute";
        }

        productAccess.writeProductToBase(product);
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
                        product.getEntityId().toString()));

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

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);
        stringBuilder.append(name);
        stringBuilder.append(middle);
        stringBuilder.append(dataToDisplay);
        stringBuilder.append(suffix);

        return stringBuilder.toString();
    }
}
