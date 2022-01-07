package com.github.damiankacprzak.helloworld.presentation.base;

public interface MvpPresenter<V> {
    void attach(V view);
    void detach();
}
