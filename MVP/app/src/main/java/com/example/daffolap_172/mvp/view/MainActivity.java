package com.example.daffolap_172.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.daffolap_172.mvp.R;
import com.example.daffolap_172.mvp.manager.CacheModel;
import com.example.daffolap_172.mvp.model.Heros;
import com.example.daffolap_172.mvp.presenter.ILoginResponseReceiver;
import com.example.daffolap_172.mvp.presenter.MainPresenter;
import com.example.daffolap_172.mvp.presenter.PresenterInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements ViewInterface{


    ListView listView;
    ILoginResponseReceiver mPresenter;
    List<Heros> heroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        mPresenter=new MainPresenter(this);
        mPresenter.getHeroes();
    }


    @Override
    public void onSuccess(List<Heros> heros) {
        heroList=heros;
        String[] heroes = new String[heroList.size()];
        for (int i = 0; i < heroList.size(); i++) {
            heroes[i] = heroList.get(i).getName();
       }
        //displaying the string array into listview
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heroes));
    }

    @Override
    public void failure() {
        Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show();

    }
}
