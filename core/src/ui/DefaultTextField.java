package ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.visualg.global.Config;

import java.util.function.Consumer;

public class DefaultTextField extends TextField {

    public DefaultTextField(String defaultValue, Consumer<String> valueConsumer) {
        super(defaultValue, Config.skin);
        this.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER) {
                    valueConsumer.accept(getText());
                }
                return false;
            }
        });
        this.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusListener.FocusEvent event, Actor actor, boolean focused) {
                if (!focused) {
                    valueConsumer.accept(getText());
                }
            }
            @Override
            public void scrollFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused) {
                    valueConsumer.accept(getText());
                }
            }
        });
    }

}
