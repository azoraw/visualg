package com.visualg.ui.upRightMenu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static com.visualg.global.Config.musicController;
import static com.visualg.global.Config.skin;

public class MuteMusicButton extends TextButton {

    public MuteMusicButton() {
        super("mute", skin);
        addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                onChange((MuteMusicButton) actor);
            }
        });
    }

    private void onChange(MuteMusicButton actor) {
        if (musicController.isPlaying()) {
            musicController.mute();
            actor.setText("unmute");
        } else {
            musicController.unmute();
            actor.setText("mute");
        }
    }
}
