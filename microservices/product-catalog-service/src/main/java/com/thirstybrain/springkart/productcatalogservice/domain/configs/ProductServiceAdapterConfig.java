package com.thirstybrain.springkart.productcatalogservice.domain.configs;

import com.thirstybrain.springkart.productcatalogservice.domain.adapter.ProductServiceAdapter;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository.ProductPort;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceAdapterConfig {

    @Bean
    public ProductService getProductService(ProductPort productPort) {
        return new ProductServiceAdapter(productPort);
    }
}
