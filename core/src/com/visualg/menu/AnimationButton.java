package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.visualg.global.Animation;
import com.visualg.global.Config;

class AnimationButton extends TextButton {

    public AnimationButton(String text, Animation animation) {
        super(text, Config.skin);
        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                actor.fire(new ChangeAnimationEvent(animation));
            }
        });
    }
}
