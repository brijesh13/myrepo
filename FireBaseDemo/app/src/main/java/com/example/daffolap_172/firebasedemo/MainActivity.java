package com.example.daffolap_172.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //


//
//        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
//
//        Map<String,String> values=new HashMap<>();
//
//        values.put("Rob","bob");
//
//        databaseReference.push().setValue(values, new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//                if(databaseError==null)
//                {
//                    Log.i("Info","Save Successful");
//                }
//                else
//                {
//                    Log.i("Info","Save Failed");
//                }
//
//            }
//        });


    }
}
