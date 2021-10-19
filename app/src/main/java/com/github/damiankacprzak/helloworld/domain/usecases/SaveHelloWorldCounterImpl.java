package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class SaveHelloWorldCounterImpl implements SaveHelloWorldCounter {

    private AppPreferencesRepository appPreferences;

    @Inject
    public SaveHelloWorldCounterImpl(AppPreferencesRepository appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public void save(Counter counter) {
        appPreferences.saveHelloWorldCounter(counter.getValue());
    }
}
