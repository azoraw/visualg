package com.visualg.controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.visualg.global.Config;

public class MusicController {
    private final Music music;

    public MusicController() {
        music = Gdx.audio.newMusic(Gdx.files.internal("background_music.wav"));
        music.setLooping(true);
        setVolume(Config.getUserProperties().getVolume());
        if (!Config.getUserProperties().isMute()) {
            music.play();
        }
    }

    public void setVolume(int volume) {
        music.setVolume(volume / 100f);
        Config.getUserProperties().saveVolume(volume);
    }

    public void mute() {
        music.pause();
        Config.getUserProperties().saveMute(true);
    }

    public void unmute() {
        music.play();
        Config.getUserProperties().saveMute(false);
    }

    public boolean isPlaying() {
        return music.isPlaying();
    }
}
