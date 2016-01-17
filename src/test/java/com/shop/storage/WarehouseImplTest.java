package com.shop.storage;

import com.shop.Product;
import com.shop.ProductImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class WarehouseImplTest {
    private Warehouse warehouse = new WarehouseImpl();
    private List<Product> testProductsList = new ArrayList<>();
    private String[] dataForProductsId = {"id11", "id22", "id33"};
    private String[] dataForProductsName = {"iPhone", "GalaxyS", "3310i"};
    private String[] dataForProductsPrice = {"200", "300", "11"};
    private String[] dataForProductsTax = {"8", "18", "15"};

    @Before
    public void setup() {
        prepareTestList();

        for (Product product : testProductsList) {
            warehouse.addProduct(product);
        }
    }

    @Test
    public void shouldReturnListWithProductInProductListInTest() throws Exception {
        int numbersOfProducts = testProductsList.size();
        List<Product> listFormMethod = warehouse.getAllProduct();

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

            testProductsList.add(product);
        }
    }
}