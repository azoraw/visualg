package com.visualg.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import lombok.Builder;

import java.util.function.Consumer;

import static com.visualg.global.Config.skin;

@Builder
public class DefaultSettingsRow {

    private final String label;
    private final String initValue;
    private final Consumer<String> onValueChange;
    @Builder.Default
    private final Consumer<String> afterValueChange = (defaultString) -> {};

    public Label getLabel() {
        return new Label(label, skin);
    }

    public TextField getTextField() {
        return new DefaultTextField(initValue, onValueChange.andThen(afterValueChange));
    }
}
