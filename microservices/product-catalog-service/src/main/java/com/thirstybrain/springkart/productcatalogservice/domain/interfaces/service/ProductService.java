package com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service;

import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    int addProduct(ProductDomain product);
    int updateProduct(ProductDomain productDomain);
    void removeProduct(ProductDomain product);

    List<ProductDomain> getProducts() throws IOException;

    ProductDomain getProductById(Integer productId);

    void index() throws IOException;
    String save(ProductDomain product) throws IOException;
    List<ProductDomain> readAll() throws IOException;
    String delete(String id) throws IOException;
}
