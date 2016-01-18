package com.shop.storage;

import com.shop.wares.Product;
import com.shop.wares.ProductImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImplTest {
    private Warehouse warehouse = new WarehouseImpl();
    private Map<Product, String> testProductsList = new HashMap<>();
    private String[] dataForProductsId = {"id11", "id22", "id33"};
    private String[] dataForProductsName = {"iPhone", "GalaxyS", "3310i"};
    private String[] dataForProductsPrice = {"200", "300", "11"};
    private String[] dataForProductsTax = {"8", "18", "15"};
    private String[] dataForProductsAmount = {"400", "300", "500"};
    private Integer subtractAndAddValue = 50;

    @Before
    public void setup() {
        prepareTestList();

        for (Map.Entry<Product, String> productStringEntry : testProductsList.entrySet()) {
            warehouse.addProductToWarehouse(
                    productStringEntry.getKey(),
                    productStringEntry.getValue());
        }
    }

    @Test
    public void shouldReturnListWithProductInProductListInTest() throws Exception {
        int numbersOfProducts = testProductsList.size();
        Map<Product, Integer> listFormMethod = warehouse.getAllProduct();

        assertEquals(numbersOfProducts, listFormMethod.size());
    }

    @Test
    public void shouldReturnProductById() throws Exception {
        for (String productIdFromTestArray : dataForProductsId) {
            Product result = warehouse.getProductByID(
                    productIdFromTestArray);

            assertEquals(productIdFromTestArray, result.getId());
        }
    }

    @Test
    public void shouldReturnProductByName() throws Exception {
        for (String productNameFromTestArray : dataForProductsName) {
            Product result = warehouse.getProductByName(
                    productNameFromTestArray);

            assertEquals(productNameFromTestArray, result.getName());
        }
    }

    @Test
    public void shouldSubtractValueItemsOfProductForAllProducts() {
        Map<Product, Integer> toCompere = new HashMap<>(warehouse.getAllProduct());

        subtractValueFromList(warehouse.getAllProduct());

        assertTestForListAfterSubtract(warehouse.getAllProduct(), toCompere);
    }

    @Test
    public void shouldAddValueItemsOfProductForAllProducts() {
        Map<Product, Integer> toCompere = new HashMap<>(warehouse.getAllProduct());

        changeValueOfItemsInWarehouse(warehouse.getAllProduct());

        assertTestForListAfterChangeValue(warehouse.getAllProduct(), toCompere);
    }

    private void assertTestForListAfterChangeValue(Map<Product, Integer> allProduct, Map<Product, Integer> toCompere) {
        for (Map.Entry<Product, Integer> productIntegerEntry : toCompere.entrySet()) {
            Product product = productIntegerEntry.getKey();
            Integer expectedValue = toCompere.get(product) + subtractAndAddValue;

            assertEquals(expectedValue, allProduct.get(product));
        }
    }

    private void changeValueOfItemsInWarehouse(Map<Product, Integer> allProduct) {
        for (Product product : allProduct.keySet()) {
            warehouse.addProductToWarehouse(product, subtractAndAddValue);
        }
    }

    private void assertTestForListAfterSubtract(Map<Product, Integer> allProduct, Map<Product, Integer> toCompere) {
        for (Map.Entry<Product, Integer> productIntegerEntry : allProduct.entrySet()) {
            Product product = productIntegerEntry.getKey();
            Integer expectedValue = toCompere.get(product) - subtractAndAddValue;

            assertEquals(expectedValue, productIntegerEntry.getValue());
        }
    }

    private void subtractValueFromList(Map<Product, Integer> subtractList) {
        for (Product product : subtractList.keySet()) {
            warehouse.subtractProductFromWarehouse(product, subtractAndAddValue);
        }
    }

    private void prepareTestList() {
        for (int i=0; i<dataForProductsId.length; i++) {
            Product product = new ProductImpl();

            product.setId(
                    dataForProductsId[i]);
            product.setName(
                    dataForProductsName[i]);
            product.setNetPrice(
                    new BigDecimal(
                            dataForProductsPrice[i]));
            product.setTax(
                    new BigDecimal(
                            dataForProductsTax[i]));

            testProductsList.put(product, dataForProductsAmount[i]);
        }
    }
}