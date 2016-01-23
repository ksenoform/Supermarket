package com.shop.storage;

import com.shop.wares.Product;

/**
 * Created by RSzczygielski on 23.01.16.
 */
public interface InventoryDAO {
    public void setItemsOfProduct(Product product, Integer items);
    public Integer getItemsOfProduct(Product product);
}
