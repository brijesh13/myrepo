package com.example.daffolap_172.roomdemo.manager;

import android.arch.persistence.room.Room;
import android.util.Log;
import android.widget.Toast;

import com.example.daffolap_172.roomdemo.model.User;
import com.example.daffolap_172.roomdemo.presenter.PresenterClass;
import com.example.daffolap_172.roomdemo.presenter.PresenterInterface;
import com.example.daffolap_172.roomdemo.view.MainActivity;

import java.util.List;

public class ManagerClass implements ManagerInterface {
   // @Override
    PresenterClass mPresenter;

    public ManagerClass(PresenterClass mPresenter)
    {
        this.mPresenter=mPresenter;
    }
    public void insert(int user_id,String name,String email) {
        User user=new User();

        user.setEmail(email);

        user.setId(user_id);

        user.setName(name);

        PresenterClass.myAppDatabase.myDao().addUser(user);

        mPresenter.datbaseCallbackSuccess();

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void view() {

       List<User> users= PresenterClass.myAppDatabase.myDao().getUsers();

       for(User user:users)
       {
           int id=user.getId();

           String name=user.getName();

           String email=user.getEmail();

           Log.i("View"," "+name+" "+email);
       }

    }
}
