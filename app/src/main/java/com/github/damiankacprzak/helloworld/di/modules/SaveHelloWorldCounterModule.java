package com.github.damiankacprzak.helloworld.di.modules;

import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SaveHelloWorldCounterModule {
    @Provides
    public SaveHelloWorldCounter provideSaveHelloWorldCounter(SaveHelloWorldCounterImpl saveHelloWorldCounter) {
        return saveHelloWorldCounter;
    }
}
