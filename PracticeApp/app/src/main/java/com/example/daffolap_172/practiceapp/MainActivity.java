package com.example.daffolap_172.practiceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button add,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button) findViewById(R.id.add);
        show=(Button) findViewById(R.id.show);
        add.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==add) {

            Intent intent=new Intent(this,AddInfo.class);
            startActivity(intent);
        }
        else if(view==show){
            Intent intent=new Intent(this,ShowInfo.class);
            startActivity(intent);
        }

    }
}
