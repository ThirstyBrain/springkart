package com.thirstybrain.springkart.productcatalogservice.infrastructure.configs;

import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository.ProductPort;
import com.thirstybrain.springkart.productcatalogservice.infrastructure.adapters.ProductAdapter;
import com.thirstybrain.springkart.productcatalogservice.infrastructure.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaDataAdapterConfig {

    @Bean
    public ProductPort getProductPort(ProductRepository productRepository){
        return new ProductAdapter(productRepository);
    }

}
