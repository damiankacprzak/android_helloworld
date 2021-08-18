package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

public class SaveHelloWorldCounterImpl implements SaveHelloWorldCounter {
    private AppPreferences appPreferences;

    public SaveHelloWorldCounterImpl() {
        appPreferences = new AppPreferencesRepository();
    }

    @Override
    public void save(Counter counter) {
        appPreferences.saveHelloWorldCounter(counter.getValue());
    }
}
