package com.example.daffolap_172.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
//import android.databinding.generated.callback.OnClickListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.daffolap_172.databinding.databinding.ActivityMainBinding;
import com.example.daffolap_172.databinding.databinding.CricketBinding;
import com.example.daffolap_172.databinding.databinding.TestBinding;


import java.util.ArrayList;

public class Cricket extends ArrayAdapter<Icons> {

    private Context mContext;
    private CricketBinding binding;
    private TestBinding imgBinding;
    static int imagePos;
    private  View convertView;
    private ActivityMainBinding activityMainBinding;
    private ArrayList<Icons> iconsArrayList=new ArrayList<>();
    private ItemClickListener mListener;

    public Cricket(Context context, ArrayList<Icons> arrayList, ItemClickListener mListener)
    {
        super(context,0,arrayList);
        mContext=context;
        iconsArrayList=arrayList;
        this.mListener = mListener;
    }

    @NonNull
    //@Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        imagePos=position;

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cricket, null);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        }else{
            binding = (CricketBinding) convertView.getTag();
        }
        convertView.findViewById(R.id.imageView).setTag(position);
        Log.i("hii",position+"");
        binding.setCallback(mListener);
        binding.setIcons(iconsArrayList.get(position));
        return binding.getRoot();
    }

}
