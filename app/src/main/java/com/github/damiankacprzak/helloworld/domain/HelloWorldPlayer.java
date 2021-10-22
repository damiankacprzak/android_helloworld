package com.github.damiankacprzak.helloworld.domain;

import android.content.Context;
import android.media.MediaPlayer;

import com.github.damiankacprzak.helloworld.R;

import javax.inject.Inject;

public class HelloWorldPlayer implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;
    private Context appContext;

    @Inject
    public HelloWorldPlayer(Context context) {
        appContext = context;
    }

    public boolean isPlaying() {

        if (mediaPlayer == null) return false;

        try {
            return mediaPlayer.isPlaying();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void play() {
        mediaPlayer = MediaPlayer.create(appContext, R.raw.hello_world);
        mediaPlayer.setLooping(false);

        mediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
