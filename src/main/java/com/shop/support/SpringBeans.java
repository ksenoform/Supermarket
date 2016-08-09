package com.shop.support;

import com.shop.storage.interfaces.Warehouse;
import com.shop.storage.implementations.WarehouseImpl;
import com.shop.storage.interfaces.Product;
import com.shop.storage.implementations.ProductBuilderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RSzczygielski on 2016-01-19.
 */
@Configuration
public class SpringBeans {
    @Bean
    public Warehouse warehouse() {
        return new WarehouseImpl();
    }

    @Bean
    public Product product() {
        return new ProductBuilderImpl().build();
    }
}
