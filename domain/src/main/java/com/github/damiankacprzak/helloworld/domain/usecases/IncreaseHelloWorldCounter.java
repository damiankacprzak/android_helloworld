package com.github.damiankacprzak.helloworld.domain.usecases;

import com.github.damiankacprzak.helloworld.domain.model.Counter;

public interface IncreaseHelloWorldCounter {
    void increase(Counter counter);
}
