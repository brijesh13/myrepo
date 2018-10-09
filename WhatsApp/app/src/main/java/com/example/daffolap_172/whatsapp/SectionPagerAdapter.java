package com.example.daffolap_172.whatsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

class SectionPagerAdapter extends FragmentPagerAdapter{


    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                RequestFragment requestFragment=new RequestFragment();

                return requestFragment;
            case 1:
                ChatFragment chatFragment=new ChatFragment();

                return chatFragment;
            case 2:
                FriendsFragment friendsFragment=new FriendsFragment();
                return friendsFragment;
            default:return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
         switch (position)

         {
             case 0:
                return "Requests";
             case 1:
                return "Chats";
             case 2:
                return "Friends";
             default:
                 return null;
             
         }
    }
}
