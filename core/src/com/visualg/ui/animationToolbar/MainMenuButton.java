package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.visualg.controls.events.MainMenuEvent;
import com.visualg.global.Config;

class MainMenuButton extends TextButton {

    MainMenuButton() {
        super("Main Menu", Config.skin);
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                actor.fire(new MainMenuEvent());
            }
        });
    }
}