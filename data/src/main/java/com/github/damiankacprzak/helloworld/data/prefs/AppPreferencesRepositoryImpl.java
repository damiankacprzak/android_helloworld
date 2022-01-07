package com.github.damiankacprzak.helloworld.data.prefs;

import android.content.SharedPreferences;
import android.util.Log;

import com.github.damiankacprzak.helloworld.data.di.HelloWorldScreenScope;
import com.github.damiankacprzak.helloworld.domain.AppPreferencesRepository;

import javax.inject.Inject;


@HelloWorldScreenScope
public class AppPreferencesRepositoryImpl implements AppPreferencesRepository {
    private static final String PREF_KEY_HELLOWORLD_COUNTER = "PREF_KEY_HELLOWORLD_COUNTER";

    private SharedPreferences sharedPrefs;

    @Inject
    public AppPreferencesRepositoryImpl(SharedPreferences sharedPrefs) {
        this.sharedPrefs = sharedPrefs;

        Log.d(AppPreferencesRepositoryImpl.class.getSimpleName(),this.toString());

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
