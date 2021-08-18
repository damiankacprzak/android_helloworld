package com.github.damiankacprzak.helloworld.presentation.views;

import com.github.damiankacprzak.helloworld.presentation.base.MvpPresenter;
import com.github.damiankacprzak.helloworld.presentation.base.MvpView;

public interface HelloWorldContract {
    interface View extends MvpView {
        void updateCounter(int counter);
    }

    interface Presenter extends MvpPresenter<View> {
        void sayHelloWorld();
    }
}