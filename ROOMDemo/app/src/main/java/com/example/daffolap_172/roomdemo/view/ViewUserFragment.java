package com.example.daffolap_172.roomdemo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daffolap_172.roomdemo.R;
import com.example.daffolap_172.roomdemo.model.User;
import com.example.daffolap_172.roomdemo.presenter.PresenterClass;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUserFragment extends Fragment {

    private TextView infoTextView;

    PresenterClass mPresenter;

    public ViewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_user, container, false);

        infoTextView=view.findViewById(R.id.infoView);

        mPresenter=new PresenterClass((MainActivity) getContext());

        mPresenter.view();

        return view;
    }

//    public void viewSuccess(List<User> list) {
//
//    }

}
