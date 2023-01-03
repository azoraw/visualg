package com.visualg.ui.simplifiedComponents;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.global.Config;

import java.util.function.Consumer;

public class DefaultTextField extends TextField {

    private final String defaultValue;

    public DefaultTextField(String defaultValue, Consumer<String> valueConsumer) {
        super(defaultValue, Config.skin);
        this.defaultValue = defaultValue;
        addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    accept(valueConsumer);
                }
                return false;
            }
        });
    }

    private void accept(Consumer<String> valueConsumer) {
        try {
            valueConsumer.accept(getText());
        } catch (NumberFormatException e) {
            setText(defaultValue);
            valueConsumer.accept(defaultValue);
        }
    }

}
