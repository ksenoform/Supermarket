package com.shop.storage;

import com.shop.wares.Product;
import com.shop.wares.ProductImpl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by RSzczygielski on 23.01.16.
 */
@Entity
public class InventoryDAOImpl implements InventoryDAO, Serializable {
    @Id
    @OneToOne(targetEntity = ProductImpl.class)
    @JoinColumn(name = "ID")
    private Product product;
    @Column(name = "ITEMS")
    private Integer items;

    public InventoryDAOImpl() {}

    public InventoryDAOImpl(Product product, Integer items) {
        this.product = product;
        this.items = items;
    }

    @Override
    public void setItemsOfProduct(Product product, Integer items) {
        this.product = product;
        this.items = items;
    }

    @Override
    public Integer getItemsOfProduct(Product product) {
        return this.product.equals(product)
                ? items
                : 0;
    }
}
