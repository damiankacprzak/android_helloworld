package com.github.damiankacprzak.helloworld.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.di.modules.AppModule;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import dagger.Component;

@Component(modules = {AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    Context context();
    SharedPreferences sharedPreferences();
}
