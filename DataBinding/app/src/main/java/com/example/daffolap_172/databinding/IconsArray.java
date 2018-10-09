package com.example.daffolap_172.databinding;

import java.util.ArrayList;

public class IconsArray {

    public ArrayList<Icons>  iconsArrayList;

    public Icons[] iconsArray={icons1,icons2,icons3
    ,icons4,icons5,icons6,icons7,icons8,icons9,icons10};

    public IconsArray() {
        iconsArrayList = new ArrayList<Icons>();
        for(int i=0; i<10; i++){
            iconsArrayList.add(iconsArray[i]);
        }
    }
    public static final Icons icons1 = new Icons(R.drawable.ampire,"UMPIRE",true);
    public static final Icons icons2 = new Icons(R.drawable.appicon,"BAT",false);
    public static final Icons icons3 = new Icons(R.drawable.ball,"BALL",false);
    public static final Icons icons4 = new Icons(R.drawable.baller,"BALLER",false);
    public static final Icons icons5 = new Icons(R.drawable.batbal,"BATBAL",false);
    public static final Icons icons6 = new Icons(R.drawable.bestman,"BESTMAN",false);
    public static final Icons icons7 = new Icons(R.drawable.cap,"CAP",false);
    public static final Icons icons8 = new Icons(R.drawable.centuries,"CENTURIES",false);
    public static final Icons icons9 = new Icons(R.drawable.helmet,"HELMET",false);
    public static final Icons icons10 = new Icons(R.drawable.stamp,"STAMP",false);
}
