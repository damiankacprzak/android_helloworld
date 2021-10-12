package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import dagger.Component;

@Component(modules = SharedPreferencesModule.class)
public interface SharedPreferencesComponent {
    void inject(AppPreferencesRepository appPreferencesRepository);
}
