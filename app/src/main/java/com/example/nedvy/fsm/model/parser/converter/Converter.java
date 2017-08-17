package com.example.nedvy.fsm.model.parser.converter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Converter {

    @SuppressWarnings("unused")
    private static final String TAG = Converter.class.getName();

    @NonNull
    private Context context;

    public Converter(@NonNull Context context) {
        this.context = context;
    }

    public String jsonParser() {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("config.json"), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
