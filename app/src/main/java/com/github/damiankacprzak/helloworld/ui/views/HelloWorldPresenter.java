package com.github.damiankacprzak.helloworld.ui.views;

import com.github.damiankacprzak.helloworld.HelloWorldPlayer;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesHelper;
import com.github.damiankacprzak.helloworld.ui.base.BasePresenter;

public class HelloWorldPresenter extends BasePresenter<HelloWorldContract.View> implements HelloWorldContract.Presenter {

    private AppPreferences appPreferences;
    private HelloWorldPlayer helloWorldPlayer;

    public HelloWorldPresenter() {
         appPreferences = new AppPreferencesHelper();
         helloWorldPlayer = new HelloWorldPlayer();
    }

    @Override
    public void attach(HelloWorldContract.View view) {
        super.attach(view);

        view.updateCounter(appPreferences.getHelloWorldCounter());
    }

    @Override
    public void sayHelloWorld() {
        if (!helloWorldPlayer.isPlaying()) {
            appPreferences.saveHelloWorldCounter(appPreferences.getHelloWorldCounter() + 1);
            view.updateCounter(appPreferences.getHelloWorldCounter());
            helloWorldPlayer.play();
        }
    }

    @Override
    public void detach() {
        super.detach();
    }
}
