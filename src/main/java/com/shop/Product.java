package com.shop;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class Product {
    private String name;
    private BigDecimal netPrice;
    private BigDecimal tax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        BigDecimal oneHundred = new BigDecimal("100.0");
        this.tax = (tax.equals(ZERO))
                ? ONE
                : tax.divide(oneHundred);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = netPrice.multiply(tax);
        totalPrice = totalPrice.add(netPrice);

        return totalPrice;
    }
}
