package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 10.08.16.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product extends EntityBaseForm {
    @Column(name = "NET_PRICE", nullable = false)
    private BigDecimal netPrice;
    @Column(name = "TAX", nullable = false)
    private BigDecimal tax;
    @Column(name = "ITEMS", nullable = false)
    private Integer items;

    public Product() {}

    public Product(Integer entityId, String name, String code, BigDecimal netPrice, BigDecimal tax, Integer items) {
        super(entityId, name, code);
        this.netPrice = netPrice;
        this.tax = tax;
        this.items = items;
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
        this.tax = tax;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal decimalFractionOfTax = tax.divide(new BigDecimal("100"));

        return netPrice.add(netPrice.multiply(decimalFractionOfTax));
    }
}
