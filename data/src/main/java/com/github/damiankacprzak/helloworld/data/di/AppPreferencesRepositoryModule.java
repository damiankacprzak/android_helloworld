package com.github.damiankacprzak.helloworld.data.di.modules;

import com.github.damiankacprzak.helloworld.data.di.HelloWorldScreenScope;
import com.github.damiankacprzak.helloworld.domain.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepositoryImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppPreferencesRepositoryModule {
    @Binds
    @HelloWorldScreenScope
    abstract AppPreferencesRepository provideAppPreferencesRepository(AppPreferencesRepositoryImpl appPreferencesRepositoryImpl);
}
