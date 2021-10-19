package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class GetHelloWorldCounterImpl implements GetHelloWorldCounter {

    private AppPreferencesRepository appPreferences;

    @Inject
    public GetHelloWorldCounterImpl(AppPreferencesRepository appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public Counter get() {
        return new Counter(appPreferences.getHelloWorldCounter());
    }
}
