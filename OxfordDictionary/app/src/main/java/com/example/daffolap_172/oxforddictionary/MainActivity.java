package com.example.daffolap_172.oxforddictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static void setText(String def){
        t.setText(def);
    }

   String url;
   static TextView t;
   EditText e;
   String wr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=(TextView) findViewById(R.id.description);

        e=findViewById(R.id.search_input);

    }

    private String dictionaryEntries() {
        final String language = "en";
        final String word = wr;
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }
    public void requestDictionary(View view)
    {
        wr=e.getText().toString();
        url=dictionaryEntries();
      MyDictionaryRequest myDictionaryRequest=new MyDictionaryRequest(this,e);
      myDictionaryRequest.execute(url);

    }
}
