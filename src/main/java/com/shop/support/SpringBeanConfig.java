package com.shop.support;

import com.shop.storage.Warehouse;
import com.shop.storage.WarehouseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RSzczygielski on 2016-01-19.
 */
@Configuration
public class SpringBeanConfig {

    @Bean
    public Warehouse warehouse() {
        return new WarehouseImpl();
    }
}
