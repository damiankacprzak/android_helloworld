package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppPreferencesRepositoryModule {
    @Binds
    abstract AppPreferencesRepository provideAppPreferencesRepository(AppPreferencesRepositoryImpl appPreferencesRepositoryImpl);
}
