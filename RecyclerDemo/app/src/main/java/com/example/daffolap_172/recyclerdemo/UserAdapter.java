package com.example.daffolap_172.recyclerdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>
{
    ArrayList<User> myUserList;
    public UserAdapter(ArrayList<User> userArrayList){
        this.myUserList=userArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.list_items,parent,false);
        Log.i("see this:","id created");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(myUserList.get(position).getFname());
        holder.textView2.setText(myUserList.get(position).getLname());


    }

    @Override
    public int getItemCount() {
        return myUserList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView){
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            textView2=(TextView) itemView.findViewById(R.id.textView2);
        }

    }
}
