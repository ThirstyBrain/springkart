package com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service;

import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDomain product);
    int updateProduct(ProductDomain productDomain);
    void removeProduct(ProductDomain product);

    List<ProductDomain> getProducts();

    ProductDomain getProductById(Integer productId);
}
