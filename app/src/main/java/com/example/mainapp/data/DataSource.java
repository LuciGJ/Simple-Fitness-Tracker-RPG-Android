package com.example.mainapp.data;

import android.content.Context;
import android.content.SharedPreferences;

public class DataSource {
    private DataSource() {
    }

    public static SharedPreferences getInstance(Context context) {
        return context.getSharedPreferences("MyPref", 0);

    }
}
