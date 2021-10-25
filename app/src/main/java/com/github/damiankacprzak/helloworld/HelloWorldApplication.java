package com.github.damiankacprzak.helloworld;

import android.app.Application;

import com.github.damiankacprzak.helloworld.di.components.AppComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerAppComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerHelloWorldPresenterComponent;
import com.github.damiankacprzak.helloworld.di.components.HelloWorldPresenterComponent;
import com.github.damiankacprzak.helloworld.di.modules.AppModule;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

public class HelloWorldApplication extends Application {

    private HelloWorldPresenterComponent helloWorldPresenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).sharedPreferencesModule(new SharedPreferencesModule()).build();

        helloWorldPresenterComponent = DaggerHelloWorldPresenterComponent.builder().appComponent(appComponent).build();
    }

    public HelloWorldPresenterComponent getHelloWorldPresenterComponent() {
        return helloWorldPresenterComponent;
    }
}
