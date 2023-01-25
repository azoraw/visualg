package com.visualg.ui.simplifiedComponents;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.visualg.global.Config;
import lombok.Builder;

import java.util.function.BiConsumer;

public class DefaultCheckBox extends CheckBox {

    @Builder
    public DefaultCheckBox(String label, boolean initValue, Runnable onClick, BiConsumer<DefaultCheckBox, Boolean> consumeIsChecked) {
        super(label, Config.skin);
        setChecked(initValue);
        DefaultCheckBox instance = this;
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (onClick != null) {
                    onClick.run();
                }
                if (consumeIsChecked != null) {
                    consumeIsChecked.accept(instance, !isChecked());
                }
            }
        });
    }
}
