package com.github.damiankacprzak.helloworld.data.prefs;

import android.app.Application;
import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;
import com.github.damiankacprzak.helloworld.di.components.DaggerSharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import javax.inject.Inject;

public class AppPreferencesRepository implements AppPreferences {
    private static final String PREF_KEY_HELLOWORLD_COUNTER = "PREF_KEY_HELLOWORLD_COUNTER";

    @Inject
    SharedPreferences sharedPrefs;

    public AppPreferencesRepository() {
        DaggerSharedPreferencesComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule((Application)
                        HelloWorldApplication.getAppContext())).build().inject(this);
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
