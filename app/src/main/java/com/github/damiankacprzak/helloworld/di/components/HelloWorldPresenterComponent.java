package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.presentation.views.HelloWorldActivity;

import dagger.Component;

@Component(dependencies = SharedPreferencesComponent.class)
public interface HelloWorldPresenterComponent {
    void inject(HelloWorldActivity activity);
}
