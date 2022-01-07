package com.github.damiankacprzak.helloworld;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.github.damiankacprzak.helloworld.R;

import java.io.IOException;

import javax.inject.Inject;

public class HelloWorldPlayer implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Inject
    public HelloWorldPlayer(Context appContext, MediaPlayer mediaPlayer) {
        mediaPlayer.reset();
        mediaPlayer.setOnCompletionListener(this);

        try {
            mediaPlayer.setDataSource(appContext, Uri.parse("android.resource://" +
                    appContext.getPackageName() + "/" + R.raw.hello_world));

            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.mediaPlayer = mediaPlayer;
    }

    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public void play() {
        mediaPlayer.start();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();

        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
