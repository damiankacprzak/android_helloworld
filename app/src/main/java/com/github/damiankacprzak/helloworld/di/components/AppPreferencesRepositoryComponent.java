package com.github.damiankacprzak.helloworld.di.components;

import android.content.SharedPreferences;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;

import dagger.Component;

@Component(dependencies = SharedPreferencesComponent.class)
public interface AppPreferencesRepositoryComponent {
    SharedPreferences sharedPreferences();
}
