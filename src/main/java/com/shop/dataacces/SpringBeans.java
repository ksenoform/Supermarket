package com.shop.dataacces;

import com.shop.model.Product;
import com.shop.storage.interfaces.ProductDAO;
import com.shop.storage.interfaces.Warehouse;
import com.shop.storage.implementations.local.WarehouseImpl;
import com.shop.storage.implementations.local.ProductBuilderImpl;
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
