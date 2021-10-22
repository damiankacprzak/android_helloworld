package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class GetHelloWorldCounterModule {
    @Provides
   public GetHelloWorldCounter provideGetHelloWorldCounter(GetHelloWorldCounterImpl getHelloWorldCounter) {
        return getHelloWorldCounter;
    }
}
