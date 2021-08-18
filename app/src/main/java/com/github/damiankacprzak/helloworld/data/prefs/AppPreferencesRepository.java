package com.github.damiankacprzak.helloworld.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;

public class AppPreferencesRepository implements AppPreferences {
    private static final String APP_PREFS = "APP_PREFS";
    private static final String PREF_KEY_HELLOWORLD_COUNTER = "PREF_KEY_HELLOWORLD_COUNTER";

    private final SharedPreferences sharedPrefs;

    public AppPreferencesRepository() {
        sharedPrefs = HelloWorldApplication.getAppContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }

    @Override
    public void saveHelloWorldCounter(int counter) {
        sharedPrefs.edit().putInt(PREF_KEY_HELLOWORLD_COUNTER, counter).apply();
    }

    @Override
    public int getHelloWorldCounter() {
        return sharedPrefs.getInt(PREF_KEY_HELLOWORLD_COUNTER, 1);
    }

    @Override
    public void clear() {
        sharedPrefs.edit().clear().apply();
    }
}
