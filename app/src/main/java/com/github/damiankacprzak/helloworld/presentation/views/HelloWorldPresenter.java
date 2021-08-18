package com.github.damiankacprzak.helloworld.presentation.views;

import com.github.damiankacprzak.helloworld.domain.NumberToOrdinalConverter;
import com.github.damiankacprzak.helloworld.domain.HelloWorldPlayer;
import com.github.damiankacprzak.helloworld.domain.model.Counter;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.GetHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.IncreaseHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounter;
import com.github.damiankacprzak.helloworld.domain.usecases.SaveHelloWorldCounterImpl;
import com.github.damiankacprzak.helloworld.presentation.base.BasePresenter;

public class HelloWorldPresenter extends BasePresenter<HelloWorldContract.View> implements HelloWorldContract.Presenter {

    private Counter counter;
    private GetHelloWorldCounter getHelloWorldCounter;
    private SaveHelloWorldCounter saveHelloWorldCounter;
    private IncreaseHelloWorldCounter increaseHelloWorldCounter;

    private HelloWorldPlayer helloWorldPlayer;

    public HelloWorldPresenter() {
        helloWorldPlayer = new HelloWorldPlayer();

        getHelloWorldCounter = new GetHelloWorldCounterImpl();
        increaseHelloWorldCounter = new IncreaseHelloWorldCounterImpl();
        saveHelloWorldCounter = new SaveHelloWorldCounterImpl();
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
    public void detach() {
        super.detach();
    }
}
