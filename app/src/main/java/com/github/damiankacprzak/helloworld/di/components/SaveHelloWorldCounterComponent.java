package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.presentation.views.HelloWorldPresenter;

import dagger.Component;

@Component(dependencies = AppPreferencesRepositoryComponent.class)
public interface SaveHelloWorldCounterComponent {
    void inject(HelloWorldPresenter helloWorldPresenter);
}
