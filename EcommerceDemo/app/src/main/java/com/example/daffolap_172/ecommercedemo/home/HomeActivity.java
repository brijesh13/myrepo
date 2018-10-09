package com.example.daffolap_172.ecommercedemo.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.daffolap_172.ecommercedemo.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBar actionBar;
    private List<Product> productList;
    private PopupWindow popupWindow;
    ProductDataArray productDataArray;
    private RelativeLayout relative;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    private  Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mDrawerLayout =  findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.rsz_menu__bar);
        productList=new ArrayList<>();
        productDataArray=new ProductDataArray();
        productList = productDataArray.getProductList();
        recyclerView=findViewById(R.id.recycler_view);
        recyclerViewAdapter=new RecyclerViewAdapter(this,productList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setVerticalScrollBarEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_search:
                @SuppressLint("InflateParams") View viewGroup = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);
                popupWindow=new PopupWindow(viewGroup,480,380,true);
                popupWindow.showAtLocation(relative, Gravity.NO_GRAVITY,50,30);
                final TextView search_view=viewGroup.findViewById(R.id.seach_view);
                if(search_view!=null){
                   btn=viewGroup.findViewById(R.id.send);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.i("popup",productList.size()+"");
                            for(int i=productList.size()-1;i>=0;i--)
                            {
                                if(!productList.get(i).product_brand.equals(search_view.getEditableText().toString()))
                                {   Log.i("product",productList.get(i)+"");
                                    Log.i("item",productList.get(i).product_brand);
                                    productList.remove(i);
                                    recyclerViewAdapter.notifyDataSetChanged();
                                }
                            }
                            //List<Product> newList = productDataArray.getNewProductList(search_view.getEditableText().toString());
                            //recyclerView.setAdapter(new RecyclerViewAdapter(HomeActivity.this , newList));
                            //Log.i("popup",productList.size()+"");
                        }
                    });
                }
                Button close = viewGroup.findViewById(R.id.okButton);
                close.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View popupView) {
                        popupWindow.dismiss();
                    }
                });
        }
        return super.onOptionsItemSelected(item);
    }

}
