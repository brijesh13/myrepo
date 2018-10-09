package com.example.daffolap_172.loginsignupdemo.model;

public interface HandlerInterface {
    boolean login(String email,String password);
    boolean signup(String name,String email,String password);
}
