package com.shop.storage;

import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import com.shop.wares.ProductImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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
    private String[] dataForProductsAmount = {"400", "300", "500"};
    private Integer subtractAndAddValue = 50;
    private String absentIdAndName = "absent";

    @Before
    public void setup() {
        prepareTestList();

        for (Product product : testProductsList) {
            warehouse.pubNewProductToWarehouse(product);
        }
    }

    @Test
    public void shouldReturnEmptyListWhenProductListIsEmpty() {
        Warehouse warehouseWithEmptyList = new WarehouseImpl();
        List<Product> toCheck = warehouseWithEmptyList.getAllProduct();

        assertTrue(toCheck.isEmpty());
    }

    @Test
    public void shouldReturnListWithProductInProductListInTest() throws Exception {
        int numbersOfProducts = testProductsList.size();
        List<Product> listFormMethod = warehouse.getAllProduct();

        assertEquals(numbersOfProducts, listFormMethod.size());
    }

    @Test
    public void shouldReturnDefaultProductWithoutDataById() {
        Product result = warehouse.getProductByID(absentIdAndName);
        Product expected = new ProductBuilderImpl().build();

        assertEquals(expected, result);
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
    public void shouldReturnDefaultProductWithoutDataByName() {
        Product result = warehouse.getProductByName(absentIdAndName);
        Product expected = new ProductBuilderImpl().build();

        assertEquals(expected, result);
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
    public void shouldSubtractIntegerValueItemsOfProductForAllProducts() {
        List<Product> toCompere = new ArrayList<>();
        for (Product p: warehouse.getAllProduct()) {
            toCompere.add(copyProduct(p));
        }

        subtractIntegerValueFromList(warehouse.getAllProduct());

        assertTestForListAfterSubtractFewItems(warehouse.getAllProduct(), toCompere);
    }

    @Test
    public void shouldSubtractStringValueItemsOfProductForAllProducts() {
        List<Product> toCompere = new ArrayList<>();
        for (Product p: warehouse.getAllProduct()) {
            toCompere.add(copyProduct(p));
        }

        subtractStringValueFromList(warehouse.getAllProduct());

        assertTestForListAfterSubtractFewItems(warehouse.getAllProduct(), toCompere);
    }

    @Test
    public void shouldAddValueItemsOfProductForAllProducts() {
        List<Product> toCompere = new ArrayList<>();
        for (Product p: warehouse.getAllProduct()) {
            toCompere.add(copyProduct(p));
        }

        changeValueOfItemsInWarehouse(warehouse.getAllProduct());

        assertTestForListAfterChangeValue(warehouse.getAllProduct(), toCompere);
    }

    @Test
    public void shouldAddProductWithoutAmountInStock() {
        Product addedProduct = addProductToInventory();
        List<Product> toCheck = warehouse.getAllProduct();
        Integer expectAmount = 0;
        Integer index = toCheck.indexOf(addedProduct);
        Integer amountOfAddedProduct = toCheck.get(index).getItems();

        assertEquals(expectAmount, amountOfAddedProduct);
    }

    @Test
    public void shouldReturnStringWitchAllProduct() {
        String toCheck = warehouse.toString();

        for (int i=0; i<dataForProductsId.length; i++) {
            assertTrue(toCheck.contains(dataForProductsAmount[i]));
            assertTrue(toCheck.contains(dataForProductsId[i]));
            assertTrue(toCheck.contains(dataForProductsName[i]));
            assertTrue(toCheck.contains(dataForProductsPrice[i]));
        }
    }

    private Product copyProduct(Product p) {
        Product copy = new ProductBuilderImpl()
                .setId(p.getId())
                .setItems(p.getItems())
                .setName(p.getName())
                .setNetPrice(p.getNetPrice())
                .setTax(p.getTax())
                .build();

        return copy;
    }

    private Product addProductToInventory() {
        Product product = new ProductBuilderImpl()
                .setId("new1")
                .setName("new Product")
                .setNetPrice("5")
                .setTax("0")
                .build();

        warehouse.pubNewProductToWarehouse(product);

        return product;
    }

    private void assertTestForListAfterChangeValue(List<Product> allProduct, List<Product> toCompere) {
        for (Product product : allProduct) {
            Integer index = toCompere.indexOf(product);
            Integer expectedValue = toCompere.get(index).getItems() + subtractAndAddValue;

            assertEquals(expectedValue, allProduct.get(index).getItems());
        }
    }

    private void changeValueOfItemsInWarehouse(List<Product> allProduct) {
        for (Product product : allProduct) {
            warehouse.addProductToWarehouse(product, subtractAndAddValue);
        }
    }

    private void assertTestForListAfterSubtractFewItems(List<Product> allProduct, List<Product> toCompere) {
        for (Product product : allProduct) {
            Integer index = toCompere.indexOf(product);
            Integer expectedValue = toCompere.get(index).getItems() - subtractAndAddValue;

            assertEquals(expectedValue, product.getItems());
        }
    }

    private void subtractIntegerValueFromList(List<Product> subtractList) {
        for (Product product : subtractList) {
            warehouse.subtractProductFromWarehouse(product, subtractAndAddValue);
        }
    }

    private void subtractStringValueFromList(List<Product> subtractList) {
        for (Product product : subtractList) {
            warehouse.subtractProductFromWarehouse(product,
                    subtractAndAddValue);
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
            product.setItems(
                    new Integer(dataForProductsAmount[i]));

            testProductsList.add(product);
        }
    }
}