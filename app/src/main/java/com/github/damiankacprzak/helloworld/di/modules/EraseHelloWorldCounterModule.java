package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class EraseHelloWorldCounterModule {
    @Provides
    public EraseHelloWorldCounter provideEraseHelloWorldCounter(EraseHelloWorldCounterImpl eraseHelloWorldCounter) {
        return eraseHelloWorldCounter;
    }
}
