package com.github.damiankacprzak.helloworld.ui.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.damiankacprzak.helloworld.R;

public class HelloWorldActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.helloworld_activity);
    }
}
