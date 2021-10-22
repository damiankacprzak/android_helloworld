package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class IncreaseHelloWorldCounterModule {
    @Provides
    public IncreaseHelloWorldCounter provideIncreaseHelloWorldCounter(IncreaseHelloWorldCounterImpl increaseHelloWorldCounterImpl) {
        return increaseHelloWorldCounterImpl;
    }
}
