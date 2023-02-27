package com.visualg.animations.ca;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    private final TextField ruleNumberTextField;
    private final CASettings CASettings;

    Table(CASettings CASettings) {
        this.CASettings = CASettings;

        DefaultSettingsRow ruleNumber = DefaultSettingsRow.builder()
                .label("Rule number")
                .initValue(valueOf(CASettings.getRuleNumber()))
                .onValueChange(newStringValue -> {
                    CASettings.setRuleNumber(parseInt(newStringValue));
                    fire(new RestartEvent());
                })
                .build();

        ruleNumberTextField = ruleNumber.getWidget();
        addRow(ruleNumber);

        DefaultSettingsRow animationSpeed = DefaultSettingsRow.builder()
                .label("Animation speed")
                .initValue(valueOf(CASettings.getAnimationSpeedInSec()))
                .onValueChange(newStringValue -> CASettings.setAnimationSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(animationSpeed);

        DefaultSettingsRow ruleChangeSpeed = DefaultSettingsRow.builder()
                .label("Rule change speed")
                .initValue(valueOf(CASettings.getRuleChangeSpeedInSec()))
                .onValueChange(newStringValue -> CASettings.setRuleChangeSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(ruleChangeSpeed);
        add(DefaultCheckBox.builder()
                .label("interesting")
                .initValue(CASettings.isOnlyInteresting())
                .onClick(() -> {
                    CASettings.onInterestingChange();
                    fire(new RestartEvent());
                })
                .build());
    }


    void updateRuleNumber() {
        ruleNumberTextField.setText(valueOf(CASettings.getRuleNumber()));

    }
}
