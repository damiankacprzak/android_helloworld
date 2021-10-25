package com.github.damiankacprzak.helloworld.di.modules;

import android.media.MediaPlayer;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class MediaPlayerModule {
    @Provides
    MediaPlayer provideMediaPlayer() {
        return new MediaPlayer();
    }
}
