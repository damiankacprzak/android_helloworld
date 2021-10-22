package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class IncreaseHelloWorldCounterModule {
    @Binds
    abstract IncreaseHelloWorldCounter bindsIncreaseHelloWorldCounter(IncreaseHelloWorldCounterImpl increaseHelloWorldCounterImpl);
}
