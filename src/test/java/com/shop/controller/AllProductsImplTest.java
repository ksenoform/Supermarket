package com.shop.controller;

import com.shop.controller.context.TestContext;
import com.shop.domain.Product;
import com.shop.main.config.WebAppContext;
import com.shop.service.interfaces.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Robert Szczygielski on 19.01.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class AllProductsImplTest {
    private MockMvc mockMvc;

    @Autowired
    private ProductService productService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnViewAndListOfAllProduct() throws Exception {
        Product p1 = new Product("name", "code", BigDecimal.ONE, BigDecimal.TEN, 2);

        when(productService.getAllProduct()).thenReturn(Arrays.asList(p1));

        mockMvc.perform(get("/allProducts/inventory"))
                .andExpect(status().isOk())
                .andExpect(view().name("allProducts/inventory"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/allProducts/inventory.jsp"))
                .andExpect(model().attribute("products", hasSize(1)))
                .andExpect(model().attribute("products", hasItems(
                        allOf(
                                hasProperty("name", is("name")),
                                hasProperty("code", is("code")),
                                hasProperty("netPrice", is(BigDecimal.ONE)),
                                hasProperty("items", is(2))
                        )
                )));

        verify(productService, times(1)).getAllProduct();
        verifyNoMoreInteractions(productService);
    }
}