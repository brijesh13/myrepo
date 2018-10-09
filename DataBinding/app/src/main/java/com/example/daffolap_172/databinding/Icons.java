package com.example.daffolap_172.databinding;

import android.media.Image;

public class Icons {

    private int image;

    private  String description;

    private boolean status;

    public Icons(int image, String description, boolean status) {
        this.image = image;
        this.description = description;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
