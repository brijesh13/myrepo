package com.example.daffolap_172.ecommercedemo.home;

import com.example.daffolap_172.ecommercedemo.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ProductDataArray {
    public ArrayList<Product> productList;
    ArrayList<Product> result;
    public ProductDataArray(){
        productList = new ArrayList<>();
        productList.add(new Product("Flying Machine Sk","levis","500 Rs.", R.drawable.a));
        productList.add(new Product("Fliying Machine slim","other","600 Rs.",R.drawable.b));
        productList.add(new Product("Ragzo slim","levis ","700 Rs.",R.drawable.c));
        productList.add(new Product("Flying Machine dk","local","800 Rs.",R.drawable.d));
        productList.add(new Product("levi's skinny Mens jeans","levis","900 Rs.",R.drawable.e));
        productList.add(new Product("Flying Machine mk","levis","1000 Rs.",R.drawable.f));
        productList.add(new Product("Flying Machine bk","other","2000 Rs.",R.drawable.g));
        productList.add(new Product("Flying Machine ck","Reebok","1500 Rs.",R.drawable.h));
        productList.add(new Product("Flying Machine lk","slim","1600 Rs.",R.drawable.i));
        productList.add(new Product("Flying Machine gk","slim","1670 Rs.",R.drawable.j));
        productList.add(new Product("Flying Machine Sk","other","500 Rs.",R.drawable.k));
        productList.add(new Product("Flying Machine dl","other","1200 Rs.",R.drawable.l));
        productList.add(new Product("Flying Machine gi","other","1500 Rs.",R.drawable.q));
        productList.add(new Product("Flying Machine Sk","other","1000 Rs.",R.drawable.r));
        productList.add(new Product("Flying Machine Sn","levis","600 Rs.",R.drawable.s3));
        productList.add(new Product("Flying Machine SP","levis","600 Rs.",R.drawable.s1));
        productList.add(new Product("Flying Machine Sk","boodland","600 Rs.",R.drawable.s2));
        productList.add(new Product("Flying Machine SK","boodland","600 Rs.",R.drawable.s4));
        productList.add(new Product("Flying Machine SW","boodland","760 Rs.",R.drawable.s6));
        productList.add(new Product("Flying Machine Sk","boodland","650 Rs.",R.drawable.s7));
        productList.add(new Product("Flying Machine Sk","levis","600 Rs.",R.drawable.s8));
        productList.add(new Product("Flying Machine Sk","other","1000 Rs.",R.drawable.s9));
        productList.add(new Product("Flying Machine Sk","levis","2000 Rs.",R.drawable.s10));
        productList.add(new Product("Flying Machine Sk","boodland","1600 Rs.",R.drawable.s11));
        productList.add(new Product("Flying Machine Sk","levis","1000 Rs.",R.drawable.s12));
        productList.add(new Product("Flying Machine Sk","other","1700 Rs.",R.drawable.s13));
        productList.add(new Product("Flying Machine Sk","levis","960 Rs.",R.drawable.s14));
        productList.add(new Product("Flying Machine Sk","boodland","600 Rs.",R.drawable.s15));
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public ArrayList<Product> getNewProductList(String brand) {
        result = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getProduct_brand().equals(brand)) {
                result.add(product);
            }
        }
        return this.result;
    }
}
