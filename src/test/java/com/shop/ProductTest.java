package com.shop;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductTest {
    private Product productToTest = new Product();

    @Test
    public void shouldReturn0For0AsPriceAndTax() {
        BigDecimal price = new BigDecimal(0);
        BigDecimal tax = new BigDecimal(0);
        BigDecimal expectResult = BigDecimal.ZERO;
        productToTest.setNetPrice(price);
        productToTest.setTax(tax);

        BigDecimal result = productToTest.getTotalPrice();
        assertEquals(expectResult, result);
    }

    @Test
    public void shouldReturnElevenNumbersForPriceFrom1To10AndTax10() {
        BigDecimal tax = BigDecimal.TEN;
        productToTest.setTax(tax);

        for (int currentPrice = 1; currentPrice <= 10; currentPrice++) {
            BigDecimal expectResult = (new BigDecimal(11));
            expectResult = expectResult.multiply(
                    new BigDecimal(currentPrice));

            BigDecimal price = new BigDecimal(currentPrice);
            productToTest.setNetPrice(price);

            BigDecimal result = productToTest.getTotalPrice();
            assertEquals(expectResult, result);
        }
    }

    @Test
    public void shouldReturnFractionsFrom1dot01To2dot0ForPrice1AndTaxFor1To100() {
        BigDecimal price = BigDecimal.ONE;
        productToTest.setNetPrice(price);

        for (int currentTax = 1; currentTax <= 100; currentTax++) {
            BigDecimal tax = new BigDecimal(currentTax);
            productToTest.setTax(tax);

            BigDecimal afterDot = tax.divide(new BigDecimal(100));
            BigDecimal expectResult = BigDecimal.ONE;
            expectResult = expectResult.add(afterDot);

            BigDecimal result = productToTest.getTotalPrice();

            assertEquals(expectResult, result);
        }
    }
}