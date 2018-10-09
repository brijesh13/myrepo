package com.example.daffolap_172.roomdemo.presenter;

import com.example.daffolap_172.roomdemo.model.User;

import java.util.List;

public interface PresenterInterface {
    void datbaseCallbackSuccess();
    void datbaseCallbackFailure();
    void insert();
    void view();
    void viewSuccess(List<User> list);
}
