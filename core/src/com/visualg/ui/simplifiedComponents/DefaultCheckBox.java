package com.visualg.ui.simplifiedComponents;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.visualg.global.Config;
import lombok.Builder;

public class DefaultCheckBox extends CheckBox {

    @Builder
    public DefaultCheckBox(String label, boolean initValue, Runnable onClick) {
        super(label, Config.skin);
        this.setChecked(initValue);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick.run();
            }
        });
    }
}
