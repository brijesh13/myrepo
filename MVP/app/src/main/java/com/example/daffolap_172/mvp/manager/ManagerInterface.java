package com.example.daffolap_172.mvp.manager;

import okhttp3.Cache;

public interface ManagerInterface {
    void getHeroes(Cache cache);
    void getApi(Cache cache);
}
