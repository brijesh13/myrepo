package com.example.daffolap_172.whatsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity implements ItemClickListener {
    UsersAdapter usersAdapter;
    ArrayList<Users>usersArrayList;
    private Toolbar mToolbar;
    private RecyclerView mUserListView;
    private FirebaseDatabase mFirebaseDatabase;
    FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    DocumentReference docRef;
    private TextView mName;
    private TextView mStatus;
    private String name,status,image,user_id;
    private CircleImageView mDisplayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mToolbar=(Toolbar)findViewById(R.id.user_app_bar);

        firebaseUser = mAuth.getInstance().getCurrentUser();

        db = FirebaseFirestore.getInstance();

        String uid = firebaseUser.getUid();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (document.exists()) {
                                     user_id=document.getId();
                                     name = document.getString("name");
                                     image = document.getString("image");
                                     status = document.getString("status");
                                     Users user=new Users(name,image,status,user_id);
                                     usersArrayList.add(user);
                                     usersAdapter.notifyDataSetChanged();
                            } else {
                                Log.i("aaaaaaaaa", "No such document");
                            }
                                        Log.i("AAAAA",document.getId() + " => " + document.getData());
                                    }
                                } else {
                                    Log.i("BBBBB", "Error getting documents: ", task.getException());
                                }
                            }
                });

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("All Users");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mUserListView =(RecyclerView)findViewById(R.id.userList);

        mUserListView.setHasFixedSize(true);

        mUserListView.setLayoutManager(new LinearLayoutManager(this));

        usersArrayList = new ArrayList<>();
        usersAdapter = new UsersAdapter(usersArrayList,this,this);
        mUserListView.setAdapter(usersAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(getApplicationContext(),ProfileActivity.class);
//        Log.i("name",usersArrayList.get(position).name);
        intent.putExtra("name",usersArrayList.get(position).name);
        intent.putExtra("status",usersArrayList.get(position).status);
        intent.putExtra("image",usersArrayList.get(position).image);
        intent.putExtra("user_id",usersArrayList.get(position).user_id);
        startActivity(intent);
    }
}
