package com.thirstybrain.springkart.productcatalogservice.infrastructure.configs;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Value("${spring.elasticsearch.host}")
    public String host;
    @Value("${spring.elasticsearch.port}")
    public int port;
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }

    private int timeout = 60;
    @Bean
    public RestHighLevelClient client(){
        logger.info("RestHighLevelClient");
        RestClientBuilder builder = RestClient.builder(new HttpHost(host,port,"http"));
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}
