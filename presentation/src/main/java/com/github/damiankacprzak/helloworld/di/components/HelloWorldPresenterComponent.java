package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.data.di.HelloWorldScreenScope;
import com.github.damiankacprzak.helloworld.data.di.AppPreferencesRepositoryModule;
import com.github.damiankacprzak.helloworld.di.modules.MediaPlayerModule;
import com.github.damiankacprzak.helloworld.domain.di.modules.EraseHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.domain.di.GetHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.domain.di.modules.IncreaseHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.domain.di.modules.SaveHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.presentation.views.HelloWorldActivity;

import dagger.Component;


@HelloWorldScreenScope
@Component(dependencies = AppComponent.class, modules = {AppPreferencesRepositoryModule.class, MediaPlayerModule.class, GetHelloWorldCounterModule.class,
        IncreaseHelloWorldCounterModule.class, SaveHelloWorldCounterModule.class, EraseHelloWorldCounterModule.class})
public interface HelloWorldPresenterComponent {
    void inject(HelloWorldActivity activity);
}
