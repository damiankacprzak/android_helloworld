package com.github.damiankacprzak.helloworld.di.components;

import android.content.SharedPreferences;

import dagger.Component;

@Component(dependencies = SharedPreferencesComponent.class)
public interface AppPreferencesRepositoryComponent {
    SharedPreferences sharedPreferences();
}
