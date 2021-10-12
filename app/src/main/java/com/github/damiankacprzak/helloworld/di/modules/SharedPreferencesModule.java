package com.github.damiankacprzak.helloworld.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {
    private static final String APP_PREFS = "APP_PREFS";

    private Application application;

    public SharedPreferencesModule(Application application) {
        this.application = application;
    }

    @Provides
    SharedPreferences provideSharedPreferences() {
        return application.getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
    }
}
