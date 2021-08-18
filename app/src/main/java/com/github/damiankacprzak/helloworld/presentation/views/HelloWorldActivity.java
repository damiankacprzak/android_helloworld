package com.github.damiankacprzak.helloworld.presentation.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.github.damiankacprzak.helloworld.R;

public class HelloWorldActivity extends AppCompatActivity implements HelloWorldContract.View {
    private HelloWorldPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new HelloWorldPresenter();

        setContentView(R.layout.helloworld_activity);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenter.sayHelloWorld();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.attach(this);
    }

    @Override
    public void updateCounter(int counter) {
        ((TextView) findViewById(R.id.textView_counter)).setText(String.valueOf(counter));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
