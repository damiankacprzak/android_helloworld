package com.github.damiankacprzak.helloworld.ui.views;

import com.github.damiankacprzak.helloworld.ui.base.MvpPresenter;
import com.github.damiankacprzak.helloworld.ui.base.MvpView;

public interface HelloWorldContract {
    interface View extends MvpView {
        void updateCounter(int counter);
    }

    interface Presenter extends MvpPresenter<View> {
        void sayHelloWorld();
    }
}
