package com.visualg.util.libgdx.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultTextField;
import lombok.Builder;

import java.util.Optional;
import java.util.function.Consumer;

import static com.visualg.global.Config.skin;

public class DefaultSettingsRow extends SettingsRow {

    private final Label label;
    private final TextField textField;

    @Builder
    public DefaultSettingsRow(String label, Object initValue, Consumer<String> onValueChange, Consumer<String> afterValueChange) {
        this.label = new Label(label, skin);
        textField = new DefaultTextField(String.valueOf(initValue), onValueChange.andThen(Optional.ofNullable(afterValueChange)
                .orElseGet(() -> (consumer) -> {})));
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public TextField getWidget() {
        return textField;
    }

    public void updateText(String newText) {
        textField.setText(newText);
    }


}
