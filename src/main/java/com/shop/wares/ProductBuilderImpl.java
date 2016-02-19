package com.shop.wares;

import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductBuilderImpl implements ProductBuilder {
    private Product product;

    public ProductBuilderImpl() {
        product = new ProductImpl();
        product.setId("none");
        product.setName("none");
        product.setNetPrice(
                new BigDecimal(0));
        product.setTax(
                new BigDecimal(0));
        product.setItems(0);
    }

    public ProductBuilder setId(String id) {
        product.setId(id);
        return this;
    }

    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder setNetPrice(String price) {
        product.setNetPrice(
                new BigDecimal(price));
        return this;
    }

    public ProductBuilder setNetPrice(BigDecimal price) {
        product.setNetPrice(price);
        return this;
    }

    public ProductBuilder setTax(String tax) {
        product.setTax(
                new BigDecimal(tax));
        return this;
    }

    public ProductBuilder setTax(BigDecimal tax) {
        product.setTax(tax);
        return this;
    }

    @Override
    public ProductBuilder setItems(Integer items) {
        product.setItems(items);
        return this;
    }

    public Product build() {
        return product;
    }
}
