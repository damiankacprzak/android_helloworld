package com.github.damiankacprzak.helloworld.di.components;

import com.github.damiankacprzak.helloworld.di.HelloWorldScreenScope;
import com.github.damiankacprzak.helloworld.di.modules.AppPreferencesModule;
import com.github.damiankacprzak.helloworld.di.modules.EraseHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.di.modules.GetHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.di.modules.IncreaseHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.di.modules.MediaPlayerModule;
import com.github.damiankacprzak.helloworld.di.modules.SaveHelloWorldCounterModule;
import com.github.damiankacprzak.helloworld.presentation.views.HelloWorldActivity;

import dagger.Component;


@HelloWorldScreenScope
@Component(dependencies = AppComponent.class, modules = {AppPreferencesModule.class, MediaPlayerModule.class, GetHelloWorldCounterModule.class,
        IncreaseHelloWorldCounterModule.class, SaveHelloWorldCounterModule.class, EraseHelloWorldCounterModule.class})
public interface HelloWorldPresenterComponent {
    void inject(HelloWorldActivity activity);
}
