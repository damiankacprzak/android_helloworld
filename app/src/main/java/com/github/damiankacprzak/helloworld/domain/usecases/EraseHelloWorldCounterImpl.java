package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;

public class EraseHelloWorldCounterImpl implements EraseHelloWorldCounter {
    private AppPreferences appPreferences;

    public EraseHelloWorldCounterImpl() {
        appPreferences = new AppPreferencesRepository();
    }

    @Override
    public void erase() {
        appPreferences.clearHelloWorldCounter();
    }
}
