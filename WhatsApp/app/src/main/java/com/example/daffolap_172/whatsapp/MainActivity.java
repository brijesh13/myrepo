package com.example.daffolap_172.whatsapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    android.support.v7.widget.Toolbar toolbar;

    private SectionPagerAdapter sectionPagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.main_tool_bar);
        toolbar.setBackgroundColor(getColor(R.color.colorPrimary));

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Lets Chat");

        viewPager = (ViewPager) findViewById(R.id.main_pager);

        mAuth = FirebaseAuth.getInstance();

        sectionPagerAdapter =new SectionPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(sectionPagerAdapter);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(viewPager);



    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            sendToStart();
        }
    }

    private void sendToStart() {

        Intent intent=new Intent(MainActivity.this,StartActivity.class);

        startActivity(intent);

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.logOut)
        {
            FirebaseAuth.getInstance().signOut();

            sendToStart();
        }
        else if(item.getItemId()==R.id.setting)
        {
            Intent intent=new Intent(MainActivity.this, UserSettingsActivity.class);
            startActivity(intent);
        }
        else  if (item.getItemId()==R.id.allUsers)
        {
            Intent intent=new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
