package com.example.daffolap_172.mvp.manager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.example.daffolap_172.mvp.model.Heros;
import com.example.daffolap_172.mvp.presenter.ILoginResponseReceiver;
import com.example.daffolap_172.mvp.presenter.MainPresenter;
import com.example.daffolap_172.mvp.presenter.PresenterInterface;
import com.example.daffolap_172.mvp.view.MainActivity;

import java.io.IOException;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class CacheModel implements ManagerInterface {

    List<Heros> heroList;

    MainPresenter mainPresenter;
    Api api;

    public CacheModel(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void getHeroes(Cache cache) {



        getApi(cache);
        Call<List<Heros>> call = api.getHeroes();

        call.enqueue(new Callback<List<Heros>>() {
            //@Override
            public void onResponse(Call<List<Heros>> call, Response<List<Heros>> response) {
                 heroList = response.body();

                 Log.i("Size" , heroList.size()+"");
                 mainPresenter.onSuccess(heroList);
            }

            @Override
            public void onFailure(Call<List<Heros>> call, Throwable t) {
                mainPresenter.onFailure();
                ///Toast.makeText(receiver, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

   public void getApi(Cache cache)
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Interceptor.Chain chain)
                            throws IOException {
                        Request request = chain.request();
                        if (!mainPresenter.isNetworkAvailable()) {
                            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale \
                            request = request
                                    .newBuilder()
                                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                    .build();
                        }
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        api = retrofit.create(Api.class);
    }

}
