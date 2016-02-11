package com.shop.support;

import com.shop.wares.ProductImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
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

        if (isBadId(product.getId())) {
            errors.rejectValue("id", "valid.new.product.id");
        }

        if (idBadName(product.getName())) {
            errors.rejectValue("name", "valid.new.product.name");
        }

        if (idBadNetPrice(product.getNetPrice())) {
            errors.rejectValue("netPrice", "valid.new.product.netPrice");
        }

        if (idBadNetTax(product.getTax())) {
            errors.rejectValue("tax", "valid.new.product.tax");
        }
    }

    private boolean isBadId(String id) {
        Pattern pattern = Pattern.compile(patternId);
        Matcher matcher = pattern.matcher(id);

        return !matcher.matches();
    }

    private boolean idBadName(String name) {
        return (name == null || name.isEmpty());
    }

    private boolean idBadNetPrice(BigDecimal netPrice) {
        return (netPrice == null || netPrice.compareTo(BigDecimal.ZERO) == 1)
                ? false
                : true;
    }

    private boolean idBadNetTax(BigDecimal tax) {
        return (tax == null || tax.compareTo(BigDecimal.ZERO) == 1)
                ? false
                : true;
    }
}
