package com.shop.service.interfaces;

import com.shop.domain.Product;

import java.math.BigDecimal;

/**
 * Created by Robert Szczygielski on 17.01.16.
 */
public interface ProductBuilder {
    ProductBuilder setName(String name);
    ProductBuilder setNetPrice(String price);
    ProductBuilder setNetPrice(BigDecimal price);
    ProductBuilder setTax(String tax);
    ProductBuilder setTax(BigDecimal tax);
    ProductBuilder setItems(Integer items);
    Product build();
}
