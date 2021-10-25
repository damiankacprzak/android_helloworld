package com.github.damiankacprzak.helloworld.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.di.ApplicationScope;
import com.github.damiankacprzak.helloworld.di.modules.AppModule;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    Context context();
    SharedPreferences sharedPreferences();
}
