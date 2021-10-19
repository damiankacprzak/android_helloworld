package com.github.damiankacprzak.helloworld.presentation.views;

import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.damiankacprzak.helloworld.HelloWorldApplication;
import com.github.damiankacprzak.helloworld.R;
import com.github.damiankacprzak.helloworld.di.components.DaggerHelloWorldPresenterComponent;
import com.github.damiankacprzak.helloworld.di.components.DaggerSharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.components.SharedPreferencesComponent;
import com.github.damiankacprzak.helloworld.di.modules.SharedPreferencesModule;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HelloWorldActivity extends AppCompatActivity implements HelloWorldContract.View {

    @Inject
    HelloWorldPresenter presenter;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.textView_counter) TextView tvCounter;

    @BindString(R.string.hello_world) String helloWorld;
    @BindString(R.string.ordinal_message) String ordinalMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.helloworld_activity);

        ButterKnife.bind(this);

        SharedPreferencesComponent sharedPreferencesComponent = DaggerSharedPreferencesComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule((Application) HelloWorldApplication.getAppContext())).build();

        DaggerHelloWorldPresenterComponent.builder().sharedPreferencesComponent(sharedPreferencesComponent).build().inject(this);

        toolbar.setTitle(helloWorld);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ic_reset) {
            presenter.clearHelloWorld();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateCounter(String counter) {
        tvCounter.setText(String.format(ordinalMessage,counter));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
