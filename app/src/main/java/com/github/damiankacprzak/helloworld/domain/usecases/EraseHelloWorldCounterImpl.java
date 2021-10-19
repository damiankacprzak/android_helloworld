package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;

import javax.inject.Inject;

public class EraseHelloWorldCounterImpl implements EraseHelloWorldCounter {

    private AppPreferencesRepository appPreferences;

    @Inject
    public EraseHelloWorldCounterImpl(AppPreferencesRepository appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public void erase() {
        appPreferences.clearHelloWorldCounter();
    }
}
