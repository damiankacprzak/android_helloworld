package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;

import dagger.Component;

@Component(dependencies = SharedPreferencesComponent.class)
public interface AppPreferencesRepositoryComponent {
    void inject(GetHelloWorldCounterImpl getHelloWorldCounter);
    void inject(SaveHelloWorldCounterImpl saveHelloWorldCounter);
    void inject(EraseHelloWorldCounterImpl eraseHelloWorldCounter);
}
