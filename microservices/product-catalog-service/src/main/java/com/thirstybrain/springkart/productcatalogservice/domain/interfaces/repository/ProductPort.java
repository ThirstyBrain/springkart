package com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository;

import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import com.thirstybrain.springkart.productcatalogservice.infrastructure.entities.Product;

import java.util.List;

public interface ProductPort {
    int addProduct(ProductDomain productDomain);
    int updateProduct(ProductDomain productDomain);
    void removeProduct(ProductDomain productDomain);
    List<ProductDomain> getProducts();
    ProductDomain getProductById(Integer productId);
}
