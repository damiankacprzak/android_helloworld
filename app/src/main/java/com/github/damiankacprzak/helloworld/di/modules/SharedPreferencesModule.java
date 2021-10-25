package com.github.damiankacprzak.helloworld.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {
    private static final String APP_PREFS = "APP_PREFS";

    @ApplicationScope
    @Provides
    SharedPreferences provideSharedPreferences(Context appContext) {
        return appContext.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }
}
