package com.github.damiankacprzak.helloworld;

import android.content.Context;
import android.media.MediaPlayer;

public class HelloWorldPlayer implements MediaPlayer.OnCompletionListener {

    public boolean isPlaying = true;
    private Context context;

    public HelloWorldPlayer(Context context) {
        this.context = context;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        isPlaying = true;
        mediaPlayer.release();
    }

    public void sayHelloWorld() {
        if (isPlaying) {
            isPlaying = false;
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.hello_world);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.start();
        }
    }
}
