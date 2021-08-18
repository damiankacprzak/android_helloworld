package com.github.damiankacprzak.helloworld.ui.views;

import com.github.damiankacprzak.helloworld.HelloWorldPlayer;
import com.github.damiankacprzak.helloworld.ui.base.BasePresenter;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;


public class HelloWorldPresenter extends BasePresenter<HelloWorldContract.View> implements HelloWorldContract.Presenter {

    private AppPreferences appPreferences;
    private HelloWorldPlayer helloWorldPlayer;

    public HelloWorldPresenter(AppPreferences appPreferences, HelloWorldPlayer helloWorldPlayer ) {
        this.appPreferences = appPreferences;
        this.helloWorldPlayer = helloWorldPlayer;
    }

    @Override
    public void attach(HelloWorldContract.View view) {
        super.attach(view);

        view.updateCounter(appPreferences.getHelloWorldCounter());
    }

    @Override
    public void sayHelloWorld() {
        if (helloWorldPlayer.isPlaying) {
            appPreferences.saveHelloWorldCounter(appPreferences.getHelloWorldCounter() + 1);
            view.updateCounter(appPreferences.getHelloWorldCounter());
            helloWorldPlayer.sayHelloWorld();
        }

    }

    @Override
    public void detach() {
        super.detach();
    }


}
