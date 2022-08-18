package com.visualg.ui.simplifiedComponents;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.visualg.global.Config;

public class DefaultButton extends TextButton {

    public DefaultButton(String label, Runnable onClicked) {
        super(label, Config.skin);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClicked.run();
            }
        });
    }
}
