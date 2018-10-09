package com.example.daffolap_172.practiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddInfo extends AppCompatActivity implements View.OnClickListener{
    private EditText name,mob,email;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        name=(EditText)findViewById(R.id.name);

        mob=(EditText)findViewById(R.id.mobile);

        email=(EditText)findViewById(R.id.email);

        save=(Button)findViewById(R.id.save);

        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==save) {

            ModelClass.setName(name.getText().toString());
            ModelClass.setMob(mob.getText().toString());
            ModelClass.setEmail(email.getText().toString());

            Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show();
        }
    }
}
