package com.github.damiankacprzak.helloworld.di.components;

import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import dagger.Component;

@Component(modules = SharedPreferencesModule.class)
public interface SharedPreferencesComponent {
    SharedPreferences sharedPreferences();
}
