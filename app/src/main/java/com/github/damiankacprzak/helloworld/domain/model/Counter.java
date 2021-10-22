package com.github.damiankacprzak.helloworld.domain.model;

import javax.inject.Inject;

public class Counter {
    private int value = 1;

    @Inject
    public Counter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
