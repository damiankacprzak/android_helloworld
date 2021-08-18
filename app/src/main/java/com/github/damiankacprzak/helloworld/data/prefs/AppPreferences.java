package com.github.damiankacprzak.helloworld.data.prefs;

public interface AppPreferences {
    void saveHelloWorldCounter(int counter);
    int  getHelloWorldCounter();
    void clear();
}
