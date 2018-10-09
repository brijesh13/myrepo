package com.example.daffolap_172.ecommercedemo.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daffolap_172.ecommercedemo.ProductActivity;
import com.example.daffolap_172.ecommercedemo.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{


    private Context mContext;
    private List<Product> productList;

    public RecyclerViewAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mLayoutInflater=LayoutInflater.from(mContext);
        view=mLayoutInflater.inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, final int position) {
        holder.product_name.setText(productList.get(position).getProduct_name());
        holder.product_price.setText(productList.get(position).getProduct_description());
        holder.product_image.setImageResource(productList.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, ProductActivity.class);
                intent.putExtra("product_name",productList.get(position).product_name);
                intent.putExtra("product_price",productList.get(position).product_description);
                intent.putExtra("product_image",productList.get(position).thumbnail);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView product_image;
        private TextView product_name,product_price;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            product_image=itemView.findViewById(R.id.product_image);
            product_name=itemView.findViewById(R.id.product_name);
            product_price=itemView.findViewById(R.id.product_price);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }
}
