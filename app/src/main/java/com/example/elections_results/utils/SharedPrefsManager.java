package com.example.elections_results.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefsManager {
    private static final String PREFS_NAME = "ElectionResultsPrefs";
    private static final String DARK_MODE_KEY = "dark_mode";

    private static SharedPrefsManager instance;
    private SharedPreferences sharedPreferences;

    private SharedPrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefsManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefsManager(context);
        }
        return instance;
    }

    public void setDarkMode(boolean enabled) {
        sharedPreferences.edit().putBoolean(DARK_MODE_KEY, enabled).apply();
    }

    public boolean getDarkMode() {
        return sharedPreferences.getBoolean(DARK_MODE_KEY, false);
    }
}