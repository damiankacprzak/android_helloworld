package com.github.damiankacprzak.helloworld.presentation.views;

import com.github.damiankacprzak.helloworld.domain.HelloWorldPlayer;
import com.github.damiankacprzak.helloworld.domain.NumberToOrdinalConverter;
import com.github.damiankacprzak.helloworld.domain.model.Counter;
import com.github.damiankacprzak.helloworld.domain.usecases.EraseHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.presentation.base.BasePresenter;

import javax.inject.Inject;

public class HelloWorldPresenter extends BasePresenter<HelloWorldContract.View> implements HelloWorldContract.Presenter {

    private Counter counter;

    private GetHelloWorldCounterImpl getHelloWorldCounter;
    private SaveHelloWorldCounterImpl saveHelloWorldCounter;

    private IncreaseHelloWorldCounterImpl increaseHelloWorldCounter;

    private EraseHelloWorldCounterImpl eraseHelloWorldCounter;  

    @Inject
    HelloWorldPlayer helloWorldPlayer;

    @Inject
    public HelloWorldPresenter(GetHelloWorldCounterImpl getHelloWorldCounter, IncreaseHelloWorldCounterImpl increaseHelloWorldCounter
            , SaveHelloWorldCounterImpl saveHelloWorldCounter, EraseHelloWorldCounterImpl eraseHelloWorldCounter) {

        this.getHelloWorldCounter = getHelloWorldCounter;
        this.increaseHelloWorldCounter = increaseHelloWorldCounter;
        this.saveHelloWorldCounter = saveHelloWorldCounter;
        this.eraseHelloWorldCounter = eraseHelloWorldCounter;
    }

    @Override
    public void attach(HelloWorldContract.View view) {
        super.attach(view);

        counter = getHelloWorldCounter.get();

        view.updateCounter(NumberToOrdinalConverter.toOrdinal(counter.getValue()));
    }

    @Override
    public void sayHelloWorld() {
        if (!helloWorldPlayer.isPlaying()) {

            increaseHelloWorldCounter.increase(counter);
            saveHelloWorldCounter.save(counter);
            view.updateCounter(NumberToOrdinalConverter.toOrdinal(counter.getValue()));
            helloWorldPlayer.play();
        }
    }

    @Override
    public void clearHelloWorld() {
        eraseHelloWorldCounter.erase();
        counter = getHelloWorldCounter.get();

        view.updateCounter(NumberToOrdinalConverter.toOrdinal(counter.getValue()));
    }

    @Override
    public void detach() {
        super.detach();
    }
}
