package com.shop.storage.implementations.local;

import com.shop.model.Product;
import com.shop.storage.interfaces.ProductDAO;
import com.shop.storage.interfaces.ProductBuilder;

import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductBuilderImpl implements ProductBuilder {
    private Product product;

    public ProductBuilderImpl() {
        product = new Product();
        product.setEntityId(0000);
        product.setName("none");
        product.setNetPrice(
                new BigDecimal(0));
        product.setTax(
                new BigDecimal(0));
        product.setItems(0);
    }

    public ProductBuilder setEntityId(Integer id) {
        product.setEntityId(id);
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
