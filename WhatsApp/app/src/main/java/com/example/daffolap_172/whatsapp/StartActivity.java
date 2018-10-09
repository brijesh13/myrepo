package com.example.daffolap_172.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    private Button regButton;

    private Button loginButton;

    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        toolbar= findViewById(R.id.main_tool_bar);
        toolbar.setBackgroundColor(getColor(R.color.colorPrimary));

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Lets Chat");

        regButton=(Button)findViewById(R.id.registerButton);

        loginButton=(Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StartActivity.this,login.class);

                startActivity(intent);
            }
        });

        regButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent intent=new Intent(StartActivity.this,RegisterActivity.class);

                startActivity(intent);
            }
        });

    }

}
