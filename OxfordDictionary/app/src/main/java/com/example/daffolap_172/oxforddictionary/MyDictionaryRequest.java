package com.example.daffolap_172.oxforddictionary;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyDictionaryRequest extends AsyncTask<String,Integer,String> {

    final String app_id = "81c21b26";
    final String app_key = "7b8edf789f2f7d3aa3ec3f7b69be2da4";
    Context mContext;
    String myUrl;

    EditText editText;

    public MyDictionaryRequest(Context mContext, EditText editText) {
        this.mContext = mContext;
        this.editText = editText;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            myUrl=params[0];
            URL url = new URL(myUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String def;
        try {
        JSONObject js=new JSONObject(s);

        JSONArray result = js.getJSONArray("results");

        JSONObject mEntries=result.getJSONObject(0);

        JSONArray laArray=mEntries.getJSONArray("lexicalEntries");

        JSONObject entries=laArray.getJSONObject(0);

        JSONArray e=entries.getJSONArray("entries");

        JSONObject jsonObject=e.getJSONObject(0);

        JSONArray sensenArray=jsonObject.getJSONArray("senses");

        JSONObject d=sensenArray.getJSONObject(0);

        JSONArray defArray=d.getJSONArray("definitions");

        def =defArray.getString(0);

        MainActivity.setText(def);

        Toast.makeText(mContext, def, Toast.LENGTH_SHORT).show();



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
