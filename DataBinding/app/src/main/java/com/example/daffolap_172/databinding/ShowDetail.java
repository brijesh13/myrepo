package com.example.daffolap_172.databinding;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.daffolap_172.databinding.databinding.ActivityShowDetailBinding;

public class ShowDetail extends AppCompatActivity {

    Icons icons;
    IconsArray iconsArray;
    ActivityShowDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this, R.layout.activity_show_detail);

        iconsArray=new IconsArray();

        Intent intent  = getIntent();
        int pos = intent.getIntExtra("position",0);
        icons=iconsArray.iconsArray[pos];
        binding.setIcons(icons);


    }
    public void changeStatus(View view){
        if(icons.isStatus()){
            icons.setStatus(false);
            MainActivity mainActivity = new MainActivity();
            mainActivity.carAdapter.notifyDataSetChanged();
            binding.setBtn(false);
        }

        else {
            icons.setStatus(true);
            MainActivity mainActivity = new MainActivity();
            mainActivity.carAdapter.notifyDataSetChanged();
            binding.setBtn(true);
        }
    }

}
