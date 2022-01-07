package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.domain.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class GetHelloWorldCounterImpl implements GetHelloWorldCounter {

    private AppPreferencesRepository appPreferencesRepository;

    @Inject
    public GetHelloWorldCounterImpl(AppPreferencesRepository appPreferencesRepository) {
        this.appPreferencesRepository = appPreferencesRepository;
    }

    @Override
    public Counter get() {
        return new Counter(appPreferencesRepository.getHelloWorldCounter());
    }
}
