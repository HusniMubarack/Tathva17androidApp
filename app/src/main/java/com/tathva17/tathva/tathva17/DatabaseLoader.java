package com.tathva17.tathva.tathva17;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by VRUSHABH on 16-10-2016.
 */

public class DatabaseLoader {

    public static String loadJSONFromAsset(Context context, String name) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(name + ".json");
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

    public static ArrayList<String> getJSONObject(Context context, String fileJson, String arrayName) {
        ArrayList<String> arr = new ArrayList<String>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(context, fileJson));
            JSONArray m_jArry = obj.getJSONArray(arrayName);
            for (int i = 0; i < m_jArry.length(); i++) {
                arr.add(i, m_jArry.getString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

}
