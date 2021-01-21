package com.thirstybrain.springkart.productcatalogservice.domain.adapter;

import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository.ProductPort;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceAdapter implements ProductService {

    @Autowired
    private ProductPort productPort;

    @Autowired
    public ProductServiceAdapter(ProductPort productPort){
        this.productPort = productPort;
    }

    @Override
    public void addProduct(ProductDomain productDomain) {
         this.productPort.addProduct(productDomain);
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


}
