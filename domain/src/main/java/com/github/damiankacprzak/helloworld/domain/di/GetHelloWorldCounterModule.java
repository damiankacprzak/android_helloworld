package com.github.damiankacprzak.helloworld.domain.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class GetHelloWorldCounterModule {
    @Binds
    abstract GetHelloWorldCounter bindsGetHelloWorldCounter(GetHelloWorldCounterImpl getHelloWorldCounterImpl);
}
