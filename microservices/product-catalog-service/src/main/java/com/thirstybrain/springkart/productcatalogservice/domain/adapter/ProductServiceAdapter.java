package com.thirstybrain.springkart.productcatalogservice.domain.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository.ProductPort;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service.ProductService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;

import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceAdapter implements ProductService {

    @Autowired
    private ProductPort productPort;


    @Autowired
    public ProductServiceAdapter(ProductPort productPort){
        this.productPort = productPort;
    }

    @Autowired
    private RestHighLevelClient client;

    @Value("${spring.elasticsearch.index-name}")
    public String INDEX_NAME;

    @Autowired
    private KafkaTemplate<String, ProductDomain> _kafkaTemplate;
    private static final String TOPIC = "ProductCatalog";

    @Override
    public int addProduct(ProductDomain productDomain) {
        int isSaved =  this.productPort.addProduct(productDomain);
        if(isSaved == 1){
            _kafkaTemplate.send(TOPIC,productDomain);
        }
        return 0;
    }

    @Override
    public int updateProduct(ProductDomain productDomain) {
        this.productPort.updateProduct(productDomain);
        return 1;
    }

    @Override
    public void removeProduct(ProductDomain productDomain) {
        this.productPort.removeProduct(productDomain);
    }

    @Override
    public List<ProductDomain> getProducts() {
        return this.productPort.getProducts();
    }

    @Override
    public ProductDomain getProductById(Integer productId) {
        return this.productPort.getProductById(productId);
    }

    @Override
    public void index() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
        GetIndexRequest getIndexRequest = new GetIndexRequest(INDEX_NAME);
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        if(!exists){
            CreateIndexResponse indexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            System.out.println("response id: "+indexResponse.index());
        }
    }

    @Override
    public String save(ProductDomain product) throws IOException {
        IndexRequest request = new IndexRequest(INDEX_NAME);
        request.id(String.valueOf(product.getProductid()));
        request.source(new ObjectMapper().writeValueAsString(product), XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println("response id: "+indexResponse.getId());
        return indexResponse.getResult().name();
    }

    @Override
    public List<ProductDomain> readAll() throws IOException {
        List<ProductDomain> products = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        searchSourceBuilder.size(5);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        for(SearchHit searchHit : searchResponse.getHits().getHits()){
            ProductDomain product = new ObjectMapper().readValue(searchHit.getSourceAsString(),ProductDomain.class);
            products.add(product);
        }
        return products;
    }

    @Override
    public String delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(INDEX_NAME,id);
        DeleteResponse deleteResponse = client.delete(request,RequestOptions.DEFAULT);
        return deleteResponse.getResult().name();
    }

    @KafkaListener(topics = TOPIC,groupId = "group_Product_Catalog_json",
            containerFactory = "userKafkaListenerFactory")
    public ProductDomain consumeJson(ProductDomain product) throws IOException {
        this.save(product);
        System.out.println("Consumed message from Topic : TestTopic  and GroupID : group_User_json is : " + product);
        return product;
    }

}
