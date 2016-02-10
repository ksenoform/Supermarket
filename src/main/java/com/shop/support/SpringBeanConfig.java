package com.shop.support;

import com.shop.storage.Warehouse;
import com.shop.storage.WarehouseImpl;
import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
        String[] filesWithMessages = {"messages/static", "messages/validator"};
        bundleMessageSource.setBasenames(filesWithMessages);

        return bundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
        lvfb.setValidationMessageSource(messageSource());
        return lvfb;
    }
}
