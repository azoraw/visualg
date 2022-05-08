package com.visualg.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import lombok.Builder;

import java.util.Optional;
import java.util.function.Consumer;

import static com.visualg.global.Config.skin;

public class DefaultSettingsRow {

    private final Label label;
    private final TextField textField;

    @Builder
    public DefaultSettingsRow(String label, String initValue, Consumer<String> onValueChange, Consumer<String> afterValueChange) {
        this.label = new Label(label, skin);
        textField = new DefaultTextField(initValue, onValueChange.andThen(Optional.ofNullable(afterValueChange)
                .orElseGet(() -> (consumer) -> {})));
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }
}
