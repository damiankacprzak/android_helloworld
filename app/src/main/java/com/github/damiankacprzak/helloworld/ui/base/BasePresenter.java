package com.github.damiankacprzak.helloworld.ui.base;

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    @Override
    public void attach(V view) {

    }

    @Override
    public void detach() {

    }
}
