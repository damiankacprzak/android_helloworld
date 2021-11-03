package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;

import javax.inject.Inject;

public class EraseHelloWorldCounterImpl implements EraseHelloWorldCounter {

    private AppPreferencesRepository appPreferencesRepository;

    @Inject
    public EraseHelloWorldCounterImpl(AppPreferencesRepository appPreferencesRepository) {
        this.appPreferencesRepository = appPreferencesRepository;
    }

    @Override
    public void erase() {
        appPreferencesRepository.clearHelloWorldCounter();
    }
}
