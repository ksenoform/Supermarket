package com.shop.storage.interfaces;

import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface ProductBuilder {
    public ProductBuilder setId(String id);
    public ProductBuilder setName(String name);
    public ProductBuilder setNetPrice(String price);
    public ProductBuilder setNetPrice(BigDecimal price);
    public ProductBuilder setTax(String tax);
    public ProductBuilder setTax(BigDecimal tax);
    public ProductBuilder setItems(Integer items);
    public Product build();
}
