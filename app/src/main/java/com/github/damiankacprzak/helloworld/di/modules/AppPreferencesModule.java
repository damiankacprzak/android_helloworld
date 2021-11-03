package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AppPreferencesModule {
    @Provides
    public AppPreferencesRepository provideAppPreferencesRepository(AppPreferencesRepositoryImpl appPreferencesRepositoryImpl) {
        return appPreferencesRepositoryImpl;
    }
}
