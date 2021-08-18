package com.github.damiankacprzak.helloworld;

import android.app.Application;
import android.content.Context;

public class HelloWorldApplication extends Application {

    private static HelloWorldApplication instance;

    public static Context getAppContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
