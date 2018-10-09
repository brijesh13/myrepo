package com.example.daffolap_172.ecommercedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView product_name,product_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        imageView=findViewById(R.id.product_image_view);
        product_name=findViewById(R.id.product_name_view);
        product_price=findViewById(R.id.product_price_view);

        Intent intent=getIntent();
        String name=intent.getExtras().getString("product_name");
        String price=intent.getExtras().getString("product_price");
        int img=intent.getExtras().getInt("product_image");
        product_name.setText(name);
        product_price.setText(price);
        imageView.setImageResource(img);
    }
}
