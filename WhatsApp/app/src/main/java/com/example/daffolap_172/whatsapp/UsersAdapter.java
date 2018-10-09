package com.example.daffolap_172.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    Context
    mContext;
    ItemClickListener itemClickListener;

    ArrayList<Users> myUserList;
    public UsersAdapter(ArrayList<Users> userArrayList, Context context,ItemClickListener itemClickListener){
        this.myUserList=userArrayList;
        this.mContext = context;
        this.itemClickListener=itemClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.user_single_layout,parent,false);
        Log.i("see this:","id created");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        Glide.with(mContext)
                .using(new FirebaseImageLoader())
                .load(FirebaseStorage.getInstance().getReference(myUserList.get(position).getImage().substring(1)))

                .into(holder.user_image);
        holder.name.setText(myUserList.get(position).getName());
        holder.status.setText(myUserList.get(position).getStatus());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myUserList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        CircleImageView user_image;
        TextView name;
        TextView status;

        public ViewHolder(View itemView){
            super(itemView);
            user_image=(CircleImageView) itemView.findViewById(R.id.user_image);
            name=(TextView)itemView.findViewById(R.id.user_single_name);
            status=(TextView) itemView.findViewById(R.id.user_defualt_status);
            mView=itemView;
        }

    }


}
