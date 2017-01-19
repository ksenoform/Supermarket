package com.shop.domain;

import com.shop.domain.abstracts.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Robert Szczygielski on 10.08.16.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractBaseEntity {
    @Column(name = "NET_PRICE", nullable = false)
    private BigDecimal netPrice;
    @Column(name = "TAX", nullable = false)
    private BigDecimal tax;
    @Column(name = "ITEMS", nullable = false)
    private Integer items;

    public Product() {}

    public Product(Integer id, String name, String code, BigDecimal netPrice, BigDecimal tax, Integer items) {
        super(id, name, code);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Product product = (Product) o;

        return uuid != null ? uuid.equals(product.uuid) : product.uuid == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}
