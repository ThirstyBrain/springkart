package com.thirstybrain.springkart.productcatalogservice.application.model.request;

public class ProductRequest {
    private int productid;
    private String description;
    private String productname;
    private double price;
    private int quantity;
    private byte[] productimage;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public byte[] getProductimage() {
        return productimage;
    }

    public void setProductimage(byte[] productimage) {
        this.productimage = productimage;
    }

    public ProductRequest(){}
    public ProductRequest(int productid, String description, String productname, double price, int quantity,
                         byte[] productimage) {
        super();
        this.productid = productid;
        this.description = description;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.productimage = productimage;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productid='").append(productid).append('\'');
        sb.append("description='").append(description).append('\'');
        sb.append("productname='").append(productname).append('\'');
        sb.append("price='").append(price).append('\'');
        sb.append("quantity='").append(quantity).append('\'');
        sb.append("productimage='").append(quantity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
