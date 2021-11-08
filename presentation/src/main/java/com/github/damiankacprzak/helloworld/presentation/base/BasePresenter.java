package com.github.damiankacprzak.helloworld.presentation.base;

public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    protected V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }
}
