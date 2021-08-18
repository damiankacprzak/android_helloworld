package com.github.damiankacprzak.helloworld.ui.base;

public interface MvpPresenter<V> {
    void attach(V view);
    void detach();
}
