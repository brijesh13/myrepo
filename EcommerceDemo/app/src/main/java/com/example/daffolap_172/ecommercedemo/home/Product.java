package com.example.daffolap_172.ecommercedemo.home;

public class Product {

    String product_name;
    String product_brand;
    String product_description;
    int thumbnail;

    public Product(String product_name, String product_brand, String product_description, int thumbnail) {
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.product_description = product_description;
        this.thumbnail = thumbnail;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
