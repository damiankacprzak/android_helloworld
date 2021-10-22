package com.github.damiankacprzak.helloworld.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {
    private static final String APP_PREFS = "APP_PREFS";

    @Provides
    SharedPreferences provideSharedPreferences(Context appContext) {
        return appContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }
}
