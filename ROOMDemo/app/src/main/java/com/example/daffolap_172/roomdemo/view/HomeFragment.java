package com.example.daffolap_172.roomdemo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.daffolap_172.roomdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  implements View.OnClickListener{

    private Button btnAddUser,btnViewUser;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        btnAddUser=view.findViewById(R.id.add_user);

        btnViewUser=view.findViewById(R.id.view_user);

        btnAddUser.setOnClickListener(this);

        btnViewUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.add_user:

                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout,new AddUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.view_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout,new ViewUserFragment())
                        .addToBackStack(null).commit();
                break;
        }

    }
}
