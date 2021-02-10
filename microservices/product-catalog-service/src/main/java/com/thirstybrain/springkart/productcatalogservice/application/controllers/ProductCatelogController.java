package com.thirstybrain.springkart.productcatalogservice.application.controllers;


import com.thirstybrain.springkart.productcatalogservice.application.model.request.ProductRequest;
import com.thirstybrain.springkart.productcatalogservice.application.model.response.ProductResponse;
import com.thirstybrain.springkart.productcatalogservice.domain.entities.ProductDomain;
import com.thirstybrain.springkart.productcatalogservice.domain.interfaces.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/rest/products")
public class ProductCatelogController {


    @Autowired
    private ProductService productService;

    @Autowired
    public ProductCatelogController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> listProductResponse = new ArrayList<>();

        List<ProductDomain> list = productService.getProducts();
        for (ProductDomain item:
                list) {
            ProductResponse responseObj = new ProductResponse();
            responseObj.setProductid(item.getProductid());
            responseObj.setDescription(item.getDescription());
            responseObj.setProductimage(item.getProductimage());
            responseObj.setProductname(item.getProductname());
            responseObj.setQuantity(item.getQuantity());
            responseObj.setPrice(item.getPrice());
            listProductResponse.add(responseObj);
        }

       return new ResponseEntity<List<ProductResponse>> (listProductResponse, HttpStatus.OK);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponse> getByProductId(@PathVariable Integer productId){
        ProductResponse productResponseObj = new ProductResponse();

        ProductDomain productDomain = this.productService.getProductById(productId);
        productResponseObj.setProductid(productDomain.getProductid());
        productResponseObj.setDescription(productDomain.getDescription());
        productResponseObj.setProductimage(productDomain.getProductimage());
        productResponseObj.setProductname(productDomain.getProductname());
        productResponseObj.setQuantity(productDomain.getQuantity());
        productResponseObj.setPrice(productDomain.getPrice());

        return new ResponseEntity<ProductResponse> (productResponseObj, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest) throws IOException {
        ProductDomain productDomain = new ProductDomain();

        productDomain.setProductid(productRequest.getProductid());
        productDomain.setDescription(productRequest.getDescription());
        productDomain.setProductimage(productRequest.getProductimage());
        productDomain.setProductname(productRequest.getProductname());
        productDomain.setQuantity(productRequest.getQuantity());
        productDomain.setPrice(productRequest.getPrice());


        this.productService.addProduct(productDomain);
        return new ResponseEntity<ProductResponse> (HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity updateProduct(@RequestBody ProductRequest productRequest){
        ProductDomain productDomain = new ProductDomain();

        productDomain.setProductid(productRequest.getProductid());
        productDomain.setDescription(productRequest.getDescription());
        productDomain.setProductimage(productRequest.getProductimage());
        productDomain.setProductname(productRequest.getProductname());
        productDomain.setQuantity(productRequest.getQuantity());
        productDomain.setPrice(productRequest.getPrice());

        this.productService.updateProduct(productDomain);
        return new ResponseEntity<ProductResponse> (HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity removeProduct(@RequestBody ProductRequest productRequest){
        ProductDomain productDomain = new ProductDomain();

        productDomain.setProductid(productRequest.getProductid());
        productDomain.setDescription(productRequest.getDescription());
        productDomain.setProductimage(productRequest.getProductimage());
        productDomain.setProductname(productRequest.getProductname());
        productDomain.setQuantity(productRequest.getQuantity());
        productDomain.setPrice(productRequest.getPrice());

        this.productService.removeProduct(productDomain);
        return new ResponseEntity<ProductResponse> (HttpStatus.OK);
    }



    @PostMapping("deleteElastic")
    public ResponseEntity deleteAll(@RequestBody String id) throws IOException {
        productService.delete(id);
        return new ResponseEntity<ProductResponse> (HttpStatus.OK);
    }
}

