package com.shop.wares;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductImpl implements Product{
    private String id;
    private String name;
    private BigDecimal netPrice;
    private BigDecimal tax;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getNetPrice() {
        return netPrice;
    }

    @Override
    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    @Override
    public BigDecimal getTax() {
        return tax;
    }

    @Override
    public void setTax(BigDecimal tax) {
        BigDecimal oneHundred = new BigDecimal("100.0");
        this.tax = (tax.equals(ZERO))
                ? ONE
                : tax.divide(oneHundred);
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = netPrice.multiply(tax);
        totalPrice = totalPrice.add(netPrice);

        return totalPrice;
    }
}
