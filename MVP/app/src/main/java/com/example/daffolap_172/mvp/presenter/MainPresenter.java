package com.example.daffolap_172.mvp.presenter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.daffolap_172.mvp.manager.CacheModel;
import com.example.daffolap_172.mvp.model.Heros;
import com.example.daffolap_172.mvp.view.MainActivity;

import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class MainPresenter implements PresenterInterface ,ILoginResponseReceiver{
    private MainActivity mViewListener;
    private CacheModel mManager;
    List<Heros> herosList;
    int cacheSize = 10 * 1024 * 1024;
    public MainPresenter(MainActivity viewListener) {
        mViewListener = viewListener;
    }
    public void getHeroes() {
        okhttp3.Cache cache = new okhttp3.Cache(mViewListener.getCacheDir(),cacheSize);
        mManager=new CacheModel(this);
        mManager.getHeroes(cache);
    }
        public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mViewListener.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onFailure() {

    }

    @Override
    public void onSuccess(List<Heros> herosList){
        mViewListener.onSuccess(herosList);
    }

}
