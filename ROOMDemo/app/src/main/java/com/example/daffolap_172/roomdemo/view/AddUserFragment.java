package com.example.daffolap_172.roomdemo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daffolap_172.roomdemo.R;
import com.example.daffolap_172.roomdemo.model.User;
import com.example.daffolap_172.roomdemo.presenter.PresenterClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    EditText userId,userEmail,userName;

    private Button btnSave;

    PresenterClass mPresenter;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);

        userId=view.findViewById(R.id.user_id);

        userName=view.findViewById(R.id.user_name);

        userEmail=view.findViewById(R.id.user_email);

        btnSave=view.findViewById(R.id.user_add);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int user_id=Integer.parseInt(userId.getText().toString());

                String user_name=userName.getText().toString();

                String user_email=userEmail.getText().toString();

                mPresenter=new PresenterClass((MainActivity) getContext(),user_id,user_name,user_email);

                mPresenter.insert();



                userId.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });
        return view;
    }

}
