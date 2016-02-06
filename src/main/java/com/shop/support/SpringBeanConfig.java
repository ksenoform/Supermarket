package com.shop.support;

import com.shop.storage.Warehouse;
import com.shop.storage.WarehouseImpl;
import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by RSzczygielski on 2016-01-19.
 */
@Configuration
public class SpringBeanConfig {

    @Bean
    public Warehouse warehouse() {
        return new WarehouseImpl();
    }

    @Bean
    public Product product() {
        return new ProductBuilderImpl().build();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("static");

        return bundleMessageSource;
    }
}
