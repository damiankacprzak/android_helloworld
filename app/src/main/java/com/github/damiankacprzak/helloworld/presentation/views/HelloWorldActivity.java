package com.github.damiankacprzak.helloworld.presentation.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.damiankacprzak.helloworld.R;

public class HelloWorldActivity extends AppCompatActivity implements HelloWorldContract.View {
    private HelloWorldPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.helloworld_activity);

        presenter = new HelloWorldPresenter();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        setSupportActionBar(toolbar);

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
        ((TextView) findViewById(R.id.textView_counter)).setText(getResources().getString(R.string.for_the, counter));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
