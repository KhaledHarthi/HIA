package com.khaledharthi.harajinterviewapp;

import android.content.Context;
import android.support.annotation.Nullable;

import com.khaledharthi.harajinterviewapp.Models.PostItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Utility {


    /**
     *
     * @param context
     * @return Array of Items read from JSON file
     */
    @Nullable
    public static ArrayList<PostItem> loadData(Context context){
        String json = readJson(context);
        ArrayList<PostItem> list = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String url = obj.getString("url");
                PostItem item = new PostItem(name, url);
                list.add(item);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return list;

    }


    private static String readJson (Context c){
        String json = null;
        try {
            InputStream is = c.getAssets().open("haraj_test_1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}
