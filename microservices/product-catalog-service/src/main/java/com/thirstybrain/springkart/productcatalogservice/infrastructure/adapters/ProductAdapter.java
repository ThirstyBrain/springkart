package com.thirstybrain.springkart.productcatalogservice.infrastructure.adapters;


import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.repository.ProductPort;
import com.thirstybrain.springkart.productcatalogservice.infrastructure.entities.Product;
import com.thirstybrain.springkart.productcatalogservice.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter implements ProductPort {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductAdapter(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public int addProduct(ProductDomain productDomain) {
        Product productEntityObj = new Product();
        productEntityObj.setProductid(productDomain.getProductid());
        productEntityObj.setDescription(productDomain.getDescription());
        productEntityObj.setProductname(productDomain.getProductname());
        productEntityObj.setProductimage(productDomain.getProductimage());
        productEntityObj.setPrice(productDomain.getPrice());
        productEntityObj.setQuantity(productDomain.getQuantity());
        Product productObj = productRepository.save(productEntityObj);
        if(productObj!=null)
            return 1;
        return 0;
    }

    @Override
    public int updateProduct(ProductDomain productDomain) {
        Product productEntityObj = this.productRepository.findByProductid(productDomain.getProductid());
        if(productEntityObj !=null){
           productEntityObj.setProductname(productDomain.getProductname());
            productEntityObj.setDescription(productDomain.getDescription());
           productEntityObj.setProductimage(productDomain.getProductimage());
           productEntityObj.setPrice(productDomain.getPrice());
           productEntityObj.setQuantity(productDomain.getQuantity());
        }
        this.productRepository.save(productEntityObj);
        return 1;
    }

    @Override
    public void removeProduct(ProductDomain productDomain) {
        Product productEntityObj = new Product();
        productEntityObj.setProductid(productDomain.getProductid());
        productEntityObj.setDescription(productDomain.getDescription());
        productEntityObj.setProductname(productDomain.getProductname());
        productEntityObj.setProductimage(productDomain.getProductimage());
        productEntityObj.setPrice(productDomain.getPrice());
        productEntityObj.setQuantity(productDomain.getQuantity());
        this.productRepository.delete(productEntityObj);
    }

    @Override
    public List<ProductDomain> getProducts(){
        List<ProductDomain> productDomainList = new ArrayList<>();

        List<Product> productEntityList = this.productRepository.findAll();
        for (Product productEntity:
             productEntityList) {
            ProductDomain  productDomainObj = new ProductDomain();
            productDomainObj.setProductid(productEntity.getProductid());
            productDomainObj.setProductid(productEntity.getProductid());
            productDomainObj.setDescription(productEntity.getDescription());
            productDomainObj.setProductimage(productEntity.getProductimage());
            productDomainObj.setProductname(productEntity.getProductname());
            productDomainObj.setQuantity(productEntity.getQuantity());
            productDomainObj.setPrice(productEntity.getPrice());
            productDomainList.add(productDomainObj);
        }
        return productDomainList;
    }

    @Override
    public ProductDomain getProductById(Integer productId) {
        Product productEntity = this.productRepository.findByProductid(productId);

        ProductDomain  productDomainObj = new ProductDomain();
        productDomainObj.setProductid(productEntity.getProductid());
        productDomainObj.setProductid(productEntity.getProductid());
        productDomainObj.setDescription(productEntity.getDescription());
        productDomainObj.setProductimage(productEntity.getProductimage());
        productDomainObj.setProductname(productEntity.getProductname());
        productDomainObj.setQuantity(productEntity.getQuantity());
        productDomainObj.setPrice(productEntity.getPrice());

       return productDomainObj;
    }
}
