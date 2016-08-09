package com.shop.storage.implementations;

import com.shop.storage.implementations.ProductBuilderImpl;
import com.shop.storage.interfaces.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductBuilderTest {
    private String defaultValueForIdAndName = "none";
    private BigDecimal defaultValueForTax = BigDecimal.ONE;
    private BigDecimal defaultValueForPrice = BigDecimal.ZERO;
    private String testId = "A123";
    private String testName = "SomeName";
    private String testPriceString = "200";
    private BigDecimal testPriceBigdecimal = new BigDecimal(100);
    private String testTaxString = "10";
    private BigDecimal testTaxBigdecimal = new BigDecimal(50);
    private Product testBuild;

    @Test
    public void shouldReturnDefaultProductAfterBuild() {
        testBuild = new ProductBuilderImpl().build();

        assertTestForDefaultValue(testBuild);
    }

    @Test
    public void shouldReturnProductWithNewId() {
        testBuild = new ProductBuilderImpl()
                .setId(testId)
                .build();

        assertTestOnlyForId(testBuild);
    }

    @Test
    public void shouldReturnProductWitchNewName() {
        testBuild = new ProductBuilderImpl()
                .setName(testName)
                .build();

        assertTestOnlyForName(testBuild);
    }

    @Test
    public void shouldReturnProductWitchNewNetPriceUsingString() {
        testBuild = new ProductBuilderImpl()
                .setNetPrice(testPriceString)
                .build();

        assertTestOnlyForPriceAsString(testBuild);
    }

    @Test
    public void shouldReturnProductWitchNewNetPriceUsingBigdecimal() {
        testBuild = new ProductBuilderImpl()
                .setNetPrice(testPriceBigdecimal)
                .build();

        assertTestOnlyForPriceAsBigdecimal(testBuild);
    }

    @Test
    public void shouldReturnProductWitchNewTaxUsingString() {
        testBuild = new ProductBuilderImpl()
                .setTax(testTaxString)
                .build();

        assertTestOnlyForTaxAsString(testBuild);
    }

    @Test
    public void shouldReturnProductWitchNewTaxUsingBigdecimal() {
        testBuild = new ProductBuilderImpl()
                .setTax(testTaxBigdecimal)
                .build();

        assertTestOnlyForTaxAsBigdecimal(testBuild);
    }

    @Test
    public void shouldReturnProductWithAllNewFieldUsingBuilder() {
        testBuild = new ProductBuilderImpl()
                .setId(testId)
                .setName(testName)
                .setTax(testTaxBigdecimal)
                .setNetPrice(testPriceString)
                .build();

        assertTestForAllNewDataUsingByBuilder(testBuild);
    }

    private void assertTestForDefaultValue(Product product) {
        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(defaultValueForPrice, product.getNetPrice());
        assertEquals(defaultValueForTax, product.getTax());
    }

    private void assertTestOnlyForId(Product product) {
        assertEquals(testId, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(defaultValueForPrice, product.getNetPrice());
        assertEquals(defaultValueForTax, product.getTax());

    }

    private void assertTestOnlyForName(Product product) {
        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(testName, product.getName());
        assertEquals(defaultValueForPrice, product.getNetPrice());
        assertEquals(defaultValueForTax, product.getTax());
    }

    private void assertTestOnlyForPriceAsString(Product product) {
        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(
                new BigDecimal(testPriceString), product.getNetPrice());
        assertEquals(defaultValueForTax, product.getTax());
    }

    private void assertTestOnlyForPriceAsBigdecimal(Product product) {
        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(testPriceBigdecimal, product.getNetPrice());
        assertEquals(defaultValueForTax, product.getTax());
    }

    private void assertTestOnlyForTaxAsString(Product product) {
        BigDecimal percentOfTestedTax = new BigDecimal(testTaxString);
        percentOfTestedTax = percentOfTestedTax.divide(
                new BigDecimal(100));

        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(defaultValueForPrice, product.getNetPrice());
        assertEquals(percentOfTestedTax, product.getTax());
    }

    private void assertTestOnlyForTaxAsBigdecimal(Product product) {
        BigDecimal percentOfTestedTax = testTaxBigdecimal.divide(
                new BigDecimal(100));

        assertEquals(defaultValueForIdAndName, product.getId());
        assertEquals(defaultValueForIdAndName, product.getName());
        assertEquals(defaultValueForPrice, product.getNetPrice());
        assertEquals(percentOfTestedTax, product.getTax());
    }

    private void assertTestForAllNewDataUsingByBuilder(Product product) {
        BigDecimal percentOfTestedTax = testTaxBigdecimal.divide(
                new BigDecimal(100));

        assertEquals(testId, product.getId());
        assertEquals(testName, product.getName());
        assertEquals(
                new BigDecimal(testPriceString), product.getNetPrice());
        assertEquals(percentOfTestedTax, product.getTax());
    }
}