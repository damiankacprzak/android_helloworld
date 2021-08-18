package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.domain.model.Counter;

public class IncreaseHelloWorldCounterImpl implements IncreaseHelloWorldCounter {
    @Override
    public void increase(Counter counter) {
        counter.setValue(counter.getValue()+1);
    }
}
