package com.example.daffolap_172.ecommercedemo.sqldatabase;

import com.example.daffolap_172.ecommercedemo.home.Product;

import java.util.ArrayList;

public interface SQLiteInterface {
    ArrayList<Product> load();
    void save(int id, String name, String brand,int price,String image);
}
