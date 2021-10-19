package com.github.damiankacprzak.helloworld.presentation.views;

import android.app.Application;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;
import com.github.damiankacprzak.helloworld.di.components.AppPreferencesRepositoryComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerAppPreferencesRepositoryComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerEraseHelloWorldCounterComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerGetHelloWorldCounterComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerSaveHelloWorldCounterComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerSharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.components.SharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;
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


    Counter counter;

    @Inject
    GetHelloWorldCounterImpl getHelloWorldCounter;
    @Inject
    SaveHelloWorldCounterImpl saveHelloWorldCounter;
    @Inject
    IncreaseHelloWorldCounterImpl increaseHelloWorldCounter;
    @Inject
    EraseHelloWorldCounterImpl eraseHelloWorldCounter;

    private HelloWorldPlayer helloWorldPlayer;

    public HelloWorldPresenter() {
        helloWorldPlayer = new HelloWorldPlayer();

        SharedPreferencesComponent sharedPreferencesComponent = DaggerSharedPreferencesComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule((Application) HelloWorldApplication.getAppContext())).build();

        AppPreferencesRepositoryComponent appPreferencesRepositoryComponent = DaggerAppPreferencesRepositoryComponent.builder()
                .sharedPreferencesComponent(sharedPreferencesComponent).build();


        DaggerGetHelloWorldCounterComponent.builder().appPreferencesRepositoryComponent(appPreferencesRepositoryComponent).build().inject(this);
        DaggerSaveHelloWorldCounterComponent.builder().appPreferencesRepositoryComponent(appPreferencesRepositoryComponent).build().inject(this);
        DaggerEraseHelloWorldCounterComponent.builder().appPreferencesRepositoryComponent(appPreferencesRepositoryComponent).build().inject(this);
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
