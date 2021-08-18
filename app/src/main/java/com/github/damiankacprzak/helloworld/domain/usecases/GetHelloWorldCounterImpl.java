package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.data.prefs.AppPreferences;
import com.github.damiankacprzak.helloworld.data.prefs.AppPreferencesRepository;
import com.github.damiankacprzak.helloworld.domain.model.Counter;

public class GetHelloWorldCounterImpl implements GetHelloWorldCounter {
    private AppPreferences appPreferences;

    public GetHelloWorldCounterImpl() {
        appPreferences = new AppPreferencesRepository();
    }

    @Override
    public Counter get() {
        return new Counter(appPreferences.getHelloWorldCounter());
    }
}
