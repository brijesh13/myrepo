package com.example.daffolap_172.mvp.presenter;

import android.widget.ListView;

import com.example.daffolap_172.mvp.model.Heros;

import java.util.List;

public interface ILoginResponseReceiver {
    void getHeroes();
    void onFailure();
    void onSuccess(List<Heros> herosList);
}
