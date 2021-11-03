package com.github.damiankacprzak.helloworld.data.prefs;

public interface AppPreferencesRepository {
    void saveHelloWorldCounter(int counter);
    int  getHelloWorldCounter();
    void clearHelloWorldCounter();
}
