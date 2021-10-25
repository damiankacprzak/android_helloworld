package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SaveHelloWorldCounterModule {
    @Binds
    abstract  SaveHelloWorldCounter bindsSaveHelloWorldCounter(SaveHelloWorldCounterImpl saveHelloWorldCounterImpl);
}
