package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.visualg.controls.events.RestartEvent;
import com.visualg.global.Config;

class RestartButton extends TextButton {

    RestartButton() {
        super("Restart", Config.skin);
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                actor.fire(new RestartEvent());
            }
        });
    }
}
