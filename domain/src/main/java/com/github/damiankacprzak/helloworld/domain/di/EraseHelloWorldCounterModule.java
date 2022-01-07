package com.github.damiankacprzak.helloworld.domain.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class EraseHelloWorldCounterModule {
    @Binds
    abstract EraseHelloWorldCounter bindsEraseHelloWorldCounter(EraseHelloWorldCounterImpl eraseHelloWorldCounterImpl);
}
