package com.github.damiankacprzak.helloworld.di.modules;

import android.app.Application;
import android.content.Context;

import com.github.damiankacprzak.helloworld.di.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context context) {
        appContext = context;
    }


    @ApplicationScope
    @Provides
    Context provideApplicationContext() {
        return appContext;
    }
}
