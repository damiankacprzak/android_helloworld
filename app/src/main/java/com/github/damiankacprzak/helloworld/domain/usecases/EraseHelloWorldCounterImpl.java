package com.github.damiankacprzak.helloworld.domain.usecases;

import android.app.Application;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.di.components.DaggerAppPreferencesRepositoryComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerSharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.components.SharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import javax.inject.Inject;

public class EraseHelloWorldCounterImpl implements EraseHelloWorldCounter {
    @Inject
    AppPreferencesRepository appPreferences;

    public EraseHelloWorldCounterImpl() {
        SharedPreferencesComponent component = DaggerSharedPreferencesComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule((Application) HelloWorldApplication.getAppContext())).build();

        DaggerAppPreferencesRepositoryComponent.builder().sharedPreferencesComponent(component).build().inject(this);
    }

    @Override
    public void erase() {
        appPreferences.clearHelloWorldCounter();
    }
}
