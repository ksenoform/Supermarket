package com.shop.storage.interfaces;

import com.shop.model.Product;

import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface ProductBuilder {
    ProductBuilder setEntityId(Integer id);
    ProductBuilder setName(String name);
    ProductBuilder setNetPrice(String price);
    ProductBuilder setNetPrice(BigDecimal price);
    ProductBuilder setTax(String tax);
    ProductBuilder setTax(BigDecimal tax);
    ProductBuilder setItems(Integer items);
    Product build();
}
