package com.example.daffolap_172.whatsapp;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users {
    public String name;
    public String image;
    public String status;
    public String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Users(String name, String image, String status, String uid) {
        this.name = name;
        this.image = image;
        this.status=status;
        this.user_id=uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
