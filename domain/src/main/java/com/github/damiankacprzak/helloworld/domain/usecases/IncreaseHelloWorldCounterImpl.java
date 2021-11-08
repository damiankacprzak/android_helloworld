package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.domain.model.Counter;

import javax.inject.Inject;

public class IncreaseHelloWorldCounterImpl implements IncreaseHelloWorldCounter {

    @Inject
    public IncreaseHelloWorldCounterImpl() {
    }

    @Override
    public void increase(Counter counter) {
        counter.setValue(counter.getValue()+1);
    }
}
