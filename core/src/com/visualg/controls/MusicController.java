package com.visualg.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicController {
    private final Music music;

    public MusicController() {
        music = Gdx.audio.newMusic(Gdx.files.internal("background_music.wav"));
        music.setLooping(true);
        music.play();
    }

    public void setVolume(int volume) {
        music.setVolume(volume / (float) 100);
    }

    public void mute() {
        music.pause();
    }

    public void unmute() {
        music.play();
    }

    public boolean isPlaying() {
        return music.isPlaying();
    }
}
