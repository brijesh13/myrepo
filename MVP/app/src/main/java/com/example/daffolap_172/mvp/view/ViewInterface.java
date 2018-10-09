package com.example.daffolap_172.mvp.view;

import com.example.daffolap_172.mvp.model.Heros;

import java.util.List;

public interface ViewInterface {

    void onSuccess(List<Heros> herosList);
    void failure();
}
