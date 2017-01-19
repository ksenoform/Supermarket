package com.shop.controller.validators;

import com.shop.domain.Product;
import com.shop.service.local.ProductServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by Robert Szczygielski on 10.02.16.
 */
@Component
public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class clazz) {
        return ProductServiceImpl.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

//        if (isBadId(product.getId())) {
//            errors.rejectValue("id", "valid.new.product.id");
//        }

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

    private boolean isBadId(Integer id) {
        return !(id == null);
    }

    private boolean idBadName(String name) {
        return (name == null || name.isEmpty());
    }

    private boolean idBadNetPrice(BigDecimal netPrice) {
        return !(netPrice == null || netPrice.compareTo(BigDecimal.ZERO) == 1);
    }

    private boolean idBadNetTax(BigDecimal tax) {
        return !(tax == null || tax.compareTo(BigDecimal.ZERO) == 1);
    }
}
