package com.github.damiankacprzak.helloworld.domain.usecases;

import android.app.Application;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.di.components.DaggerAppPreferencesRepositoryComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerSharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.components.SharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class GetHelloWorldCounterImpl implements GetHelloWorldCounter {

    @Inject
    AppPreferencesRepository appPreferences;

    public GetHelloWorldCounterImpl() {
        SharedPreferencesComponent component = DaggerSharedPreferencesComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule((Application) HelloWorldApplication.getAppContext())).build();

        DaggerAppPreferencesRepositoryComponent.builder().sharedPreferencesComponent(component).build().inject(this);
    }

    @Override
    public Counter get() {
        return new Counter(appPreferences.getHelloWorldCounter());
    }
}
