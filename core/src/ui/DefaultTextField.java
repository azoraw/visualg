package ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.global.Config;

import java.util.function.Consumer;

public class DefaultTextField extends TextField {

    public DefaultTextField(String defaultValue, Consumer<String> consumer) {
        super(defaultValue, Config.skin);
        this.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.ENTER || keycode == Input.Keys.TAB) {
                    consumer.accept(getText());
                }
                return false;
            }
        });
    }

}
