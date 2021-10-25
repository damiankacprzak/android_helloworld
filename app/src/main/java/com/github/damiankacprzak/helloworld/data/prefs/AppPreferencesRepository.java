package com.github.damiankacprzak.helloworld.data.prefs;

import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.di.HelloWorldScreenScope;

import javax.inject.Inject;


 @HelloWorldScreenScope
public class AppPreferencesRepository implements AppPreferences {
    private static final String PREF_KEY_HELLOWORLD_COUNTER = "PREF_KEY_HELLOWORLD_COUNTER";

    private SharedPreferences sharedPrefs;

    @Inject
    public AppPreferencesRepository(SharedPreferences sharedPrefs) {
        this.sharedPrefs = sharedPrefs;
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
    public void clearHelloWorldCounter() {
        sharedPrefs.edit().clear().apply();
    }
}
