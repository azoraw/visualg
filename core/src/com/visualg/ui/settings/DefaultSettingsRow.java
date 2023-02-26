package com.visualg.ui.settings;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.DefaultTextField;
import lombok.Builder;

import java.util.Optional;
import java.util.function.Consumer;

public class DefaultSettingsRow extends SettingsRow {

    private final DefaultLabel label;
    private final DefaultTextField textField;

    @Builder
    public DefaultSettingsRow(String label, Object initValue, Consumer<String> onValueChange, Consumer<String> afterValueChange) {
        this.label = new DefaultLabel(label);
        textField = new DefaultTextField(String.valueOf(initValue), onValueChange.andThen(Optional.ofNullable(afterValueChange)
                .orElseGet(() -> (consumer) -> {
                })));
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public DefaultTextField getWidget() {
        return textField;
    }

    public void updateText(String newText) {
        textField.setText(newText);
    }


}
