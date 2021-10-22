package com.github.damiankacprzak.helloworld.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context context) {
        appContext = context;
    }

    @Provides
    Context provideApplicationContext() {
        return appContext;
    }
}
