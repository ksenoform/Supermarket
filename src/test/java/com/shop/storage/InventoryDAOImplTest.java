package com.shop.storage;

import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import com.shop.wares.ProductImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RSzczygielski on 04.02.16.
 */
public class InventoryDAOImplTest {
    private Integer items = 250;
    private Integer newItemValue = 100;
    private Product product = new ProductBuilderImpl().build();
    private InventoryDAO inventoryDAO = new InventoryDAOImpl();

    @Before
    public void setup() {
        inventoryDAO = new InventoryDAOImpl(product, items);
    }

    @Test
    public void shouldReturn0ForNullAsProduct() {
        Integer result = inventoryDAO.getItemsOfProduct(null);

        assertEquals(new Integer(0), result);
    }

    @Test
    public void shouldReturnItemsOfProduct() throws Exception {
        Integer result = inventoryDAO.getItemsOfProduct(product);

        assertEquals(items, result);
    }

    @Test
    public void checkIfTheItemsValueCanBeChange() {
        inventoryDAO.setItemsOfProduct(product, newItemValue);
        Integer result = inventoryDAO.getItemsOfProduct(product);

        assertEquals(newItemValue, result);
    }
}