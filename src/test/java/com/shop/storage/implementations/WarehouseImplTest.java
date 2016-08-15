package com.shop.storage.implementations;

import com.shop.dataacces.ProductAccess;
import com.shop.model.Product;
import com.shop.storage.implementations.local.ProductBuilderImpl;
import com.shop.storage.implementations.local.WarehouseImpl;
import com.shop.storage.interfaces.Warehouse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.when;

/**
 * Created by RSzczygielski on 17.01.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class WarehouseImplTest {
    @Mock
    private ProductAccess productAccess;
    @InjectMocks
    private Warehouse warehouse = new WarehouseImpl();
    private List<Product> testProductsList = new ArrayList<>();
    private Integer[] dataForProductsId = {11, 22, 33};
    private String[] dataForProductsName = {"iPhone", "GalaxyS", "3310i"};
    private String[] dataForProductsPrice = {"200", "300", "11"};
    private String[] dataForProductsTax = {"8", "18", "15"};
    private String[] dataForProductsAmount = {"400", "300", "500"};
    private Integer subtractAndAddValue = 50;
    private String absentName = "absent";
    private Integer absentId = 0000;

    @Before
    public void setup() {
        prepareTestList();
    }

    @Test
    public void shouldReturnEmptyListWhenProductListIsEmpty() {
        when(productAccess.getListOfAllProduct()).thenReturn(Collections.<Product>emptyList());
        List<Product> toCheck = warehouse.getAllProduct();

        assertTrue(toCheck.isEmpty());
    }

    @Test
    public void shouldReturnListWithProductInProductListInTest() throws Exception {
        int numbersOfProducts = testProductsList.size();
        when(productAccess.getListOfAllProduct()).thenReturn(testProductsList);
        List<Product> listFormMethod = warehouse.getAllProduct();

        assertEquals(numbersOfProducts, listFormMethod.size());
    }

    @Test
    public void shouldReturnDefaultProductWithoutDataById() {
        Product result = warehouse.getProductByID(absentId);
        Product expected = new ProductBuilderImpl().build();

        assertEquals(expected.getEntityId(), result.getEntityId());
    }

    @Test
    public void shouldReturnProductById() throws Exception {
        for (Integer productIdFromTestArray : dataForProductsId) {
            when(productAccess.getProductById(productIdFromTestArray))
                    .thenReturn(new ProductBuilderImpl().setEntityId(productIdFromTestArray)
                                        .build());
            Product result = warehouse.getProductByID(
                    productIdFromTestArray);

            assertEquals(productIdFromTestArray, result.getEntityId());
        }
    }

    @Test
    public void shouldReturnDefaultProductWithoutDataByName() {
        Product result = warehouse.getProductByName(absentName);
        Product expected = new ProductBuilderImpl().build();

        assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void shouldReturnProductByName() throws Exception {
        for (String productNameFromTestArray : dataForProductsName) {
            when(productAccess.getProductByName(productNameFromTestArray))
                    .thenReturn(new ProductBuilderImpl().setName(productNameFromTestArray)
                                .build());
            Product result = warehouse.getProductByName(
                    productNameFromTestArray);

            assertEquals(productNameFromTestArray, result.getName());
        }
    }

//    @Test
//    public void shouldSubtractIntegerValueItemsOfProductForAllProducts() {
//        List<Product> toCompere = new ArrayList<>();
//        when(productAccess.getListOfAllProduct()).thenReturn(testProductsList);
//        for (Product p: warehouse.getAllProduct()) {
//            toCompere.add(copyProduct(p));
//        }
//
//        assertTrue(!toCompere.isEmpty());
//        subtractIntegerValueFromList(warehouse.getAllProduct());
//
//        assertTestForListAfterSubtractFewItems(warehouse.getAllProduct(), toCompere);
//    }
//
//    @Test
//    public void shouldSubtractStringValueItemsOfProductForAllProducts() {
//        List<Product> toCompere = new ArrayList<>();
//        for (Product p: warehouse.getAllProduct()) {
//            toCompere.add(copyProduct(p));
//        }
//
//        subtractStringValueFromList(warehouse.getAllProduct());
//
//        assertTestForListAfterSubtractFewItems(warehouse.getAllProduct(), toCompere);
//    }
//
//    @Test
//    public void shouldAddValueItemsOfProductForAllProducts() {
//        List<Product> toCompere = new ArrayList<>();
//        for (Product p: warehouse.getAllProduct()) {
//            toCompere.add(copyProduct(p));
//        }
//
//        changeValueOfItemsInWarehouse(warehouse.getAllProduct());
//
//        assertTestForListAfterChangeValue(warehouse.getAllProduct(), toCompere);
//    }
//
//    @Test
//    public void shouldAddProductWithoutAmountInStock() {
//        Product addedProduct = addProductToInventory();
//        List<Product> toCheck = warehouse.getAllProduct();
//        Integer expectAmount = 0;
//        Integer index = toCheck.indexOf(addedProduct);
//        Integer amountOfAddedProduct = toCheck.get(index).getItems();
//
//        assertEquals(expectAmount, amountOfAddedProduct);
//    }
//
//    @Test
//    public void shouldReturnStringWitchAllProduct() {
//        String toCheck = warehouse.toString();
//
//        for (int i=0; i<dataForProductsId.length; i++) {
//            assertTrue(toCheck.contains(dataForProductsAmount[i]));
//            assertTrue(toCheck.contains(String.valueOf(dataForProductsId[i])));
//            assertTrue(toCheck.contains(dataForProductsName[i]));
//            assertTrue(toCheck.contains(dataForProductsPrice[i]));
//        }
//    }

    private Product copyProduct(Product p) {
        Product copy = new ProductBuilderImpl()
                .setEntityId(p.getEntityId())
                .setItems(p.getItems())
                .setName(p.getName())
                .setNetPrice(p.getNetPrice())
                .setTax(p.getTax())
                .build();

        return copy;
    }

    private Product addProductToInventory() {
        Product product = new ProductBuilderImpl()
                .setEntityId(0000)
                .setName("new Product")
                .setNetPrice("5")
                .setTax("0")
                .build();

        warehouse.putNewProductToWarehouse(product);

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
            warehouse.addItemToProduct(product.getEntityId(), subtractAndAddValue);
        }
    }

    private void assertTestForListAfterSubtractFewItems(List<Product> allProduct, List<Product> toCompere) {
        for (Product product : allProduct) {
            Integer index = toCompere.indexOf(product);
            Integer expectedValue = toCompere.get(index).getItems() - subtractAndAddValue;

            assertEquals(expectedValue, product.getItems());
        }
    }

//    private void subtractIntegerValueFromList(List<Product> subtractList) {
//        for (Product product : subtractList) {
//            when(productAccess.getProductById(anyInt())).thenReturn(product);
//            when(productAccess.writeProductToBase(product)).thenCallRealMethod();
//            warehouse.subItemFromProduct(product.getEntityId(), subtractAndAddValue);
//        }
//    }

    private void subtractStringValueFromList(List<Product> subtractList) {
        for (Product product : subtractList) {
            warehouse.subItemFromProduct(product.getEntityId(),
                    subtractAndAddValue);
        }
    }

    private void prepareTestList() {
        for (int i=0; i<dataForProductsId.length; i++) {
            Product product = new Product();

            product.setEntityId(
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