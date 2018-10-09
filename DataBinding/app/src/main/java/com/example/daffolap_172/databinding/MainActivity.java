package com.example.daffolap_172.databinding;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity implements ItemClickListener, AdapterView.OnItemClickListener {

ListView listView;
ImageView imageView;
private PopupWindow popupWindow;
private LayoutInflater layoutInflater;
private RelativeLayout relative;
static Cricket carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relative =findViewById(R.id.relativeLayout);
        //MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        IconsArray iconsArrayObject = new IconsArray();
        carAdapter = new Cricket(getApplicationContext(),iconsArrayObject.iconsArrayList, this);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(carAdapter);
        listView.setOnItemClickListener(this);

    }
    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

    @Override
    public void onItemClick(View view) {
        Log.d("Item Selected: ", "True");
        IconsArray iconsArray = new IconsArray();
        Icons icons=iconsArray.iconsArray[(int)view.getTag()];
        View viewGroup = LayoutInflater.from(this).inflate(R.layout.test, null);
        popupWindow=new PopupWindow(viewGroup,400,400,true);
        popupWindow.showAtLocation(relative, Gravity.NO_GRAVITY,50,200);
        ImageView  imageView=(ImageView)viewGroup.findViewById(R.id.imageOpened);
        Log.i("view00000",""+view.getTag());
        imageView.setImageResource(icons.getImage());
        Button close = (Button) viewGroup.findViewById(R.id.okButton);
        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View popupView) {
                popupWindow.dismiss();
            }
        });

    }
    public void showDetails(View view)
    {
        Log.i("AAAAAAAAAA","Hello");
//        IconsArray iconsArrayObject = new IconsArray();
//        carAdapter = new Cricket(getApplicationContext(),iconsArrayObject.iconsArrayList, this);
//        listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(carAdapter);
//              listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), ShowDetail.class);
//                intent.putExtra("position" , position);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(getApplicationContext(), ShowDetail.class);
        intent.putExtra("position" , position);
        startActivity(intent);
    }
}
