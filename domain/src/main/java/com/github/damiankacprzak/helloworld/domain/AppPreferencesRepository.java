package com.github.damiankacprzak.helloworld.domain;

public interface AppPreferencesRepository {
    void saveHelloWorldCounter(int counter);
    int  getHelloWorldCounter();
    void clearHelloWorldCounter();
}
