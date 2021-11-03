package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class SaveHelloWorldCounterImpl implements SaveHelloWorldCounter {

    private AppPreferencesRepository appPreferencesRepository;

    @Inject
    public SaveHelloWorldCounterImpl(AppPreferencesRepository appPreferencesRepository) {
        this.appPreferencesRepository = appPreferencesRepository;
    }

    @Override
    public void save(Counter counter) {
        appPreferencesRepository.saveHelloWorldCounter(counter.getValue());
    }
}
