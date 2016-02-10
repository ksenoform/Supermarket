package com.shop.support;

import com.shop.wares.ProductImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RSzczygielski on 10.02.16.
 */
@Component
public class ProductValidator implements Validator{
    private String patternId = "\\D{2}\\d+";

    @Override
    public boolean supports(Class clazz) {
        return ProductImpl.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductImpl product = (ProductImpl) o;

        if (isBadIdProduct(product.getId())) {
            errors.rejectValue("id", "valid.new.product.id");
        }
    }

    private boolean isBadIdProduct(String id) {
        Pattern pattern = Pattern.compile(patternId);
        Matcher matcher = pattern.matcher(id);

        return !matcher.matches();
    }
}
