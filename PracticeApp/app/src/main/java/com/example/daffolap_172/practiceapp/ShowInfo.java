package com.example.daffolap_172.practiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {

    private TextView name,mob,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        name=(TextView) findViewById(R.id.name);

        mob=(TextView) findViewById(R.id.mobile);

        email=(TextView) findViewById(R.id.email);

        name.setText(ModelClass.getName().toString());

        mob.setText(ModelClass.getMob().toString());

        email.setText(ModelClass.getEmail().toString());

    }

}
