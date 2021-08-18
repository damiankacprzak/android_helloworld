package com.github.damiankacprzak.helloworld.ui.views;

import com.github.damiankacprzak.helloworld.ui.base.BasePresenter;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;

public class HelloWorldPresenter extends BasePresenter<HelloWorldContract.View> implements HelloWorldContract.Presenter {

    private AppPreferences appPreferences;

    public HelloWorldPresenter(AppPreferences appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public void attach(HelloWorldContract.View view) {
        super.attach(view);
    }

    @Override
    public void sayHelloWorld() {
        appPreferences.saveHelloWorldCounter(appPreferences.getHelloWorldCounter() + 1);
        view.updateCounter(appPreferences.getHelloWorldCounter());
    }

    @Override
    public void detach() {
        super.detach();
    }
}
