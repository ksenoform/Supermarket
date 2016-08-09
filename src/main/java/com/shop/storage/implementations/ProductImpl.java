package com.shop.storage.implementations;

import com.shop.storage.interfaces.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

/**
 * Created by RSzczygielski on 17.01.16.
 */
@Entity
@Table(name = "PRODUCTS")
public class ProductImpl implements Product {
    @Id
    @Column(name = "ID", nullable = false)
    private String id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "NET_PRICE", nullable = false)
    private BigDecimal netPrice;
    @Column(name = "TAX", nullable = false)
    private BigDecimal tax;
    @Column(name = "ITEMS", nullable = false)
    private Integer items;

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
    public void setItems(Integer items) {
        this.items = items;
    }

    @Override
    public Integer getItems() {
        return items;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = netPrice.multiply(tax);
        totalPrice = totalPrice.add(netPrice);

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder productData = new StringBuilder();

        productData.append("Product id: ");
        productData.append(id);
        productData.append(", name: ");
        productData.append(name);
        productData.append(", net price: ");
        productData.append(netPrice);
        productData.append(", tax: ");
        productData.append(tax);
        productData.append(", gross price: ");
        productData.append(getTotalPrice());
        productData.append(", items: ");
        productData.append(items);

        return  productData.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductImpl product = (ProductImpl) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
