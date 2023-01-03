package com.visualg.animations.ca;

import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.DefaultLabel;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    private final TextField ruleNumberTextField;
    private final Settings settings;

    Table(Settings settings) {
        this.settings = settings;

        DefaultSettingsRow ruleNumber = DefaultSettingsRow.builder()
                .label("Rule number")
                .initValue(valueOf(settings.getRuleNumber()))
                .onValueChange(newStringValue -> settings.setRuleNumber(parseInt(newStringValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();

        ruleNumberTextField = ruleNumber.getWidget();
        addRow(ruleNumber);

        DefaultSettingsRow animationSpeed = DefaultSettingsRow.builder()
                .label("Animation speed")
                .initValue(valueOf(settings.getAnimationSpeedInSec()))
                .onValueChange(newStringValue -> settings.setAnimationSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(animationSpeed);

        DefaultSettingsRow ruleChangeSpeed = DefaultSettingsRow.builder()
                .label("Rule change speed")
                .initValue(valueOf(settings.getRuleChangeSpeedInSec()))
                .onValueChange(newStringValue -> settings.setRuleChangeSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(ruleChangeSpeed);
        add(DefaultCheckBox.builder()
                .label("interesting")
                .initValue(settings.isOnlyInteresting())
                .onClick(() -> {
                    settings.onInterestingChange();
                    fire(new RestartEvent());
                })
                .build());
    }


    void updateRuleNumber() {
        ruleNumberTextField.setText(valueOf(settings.getRuleNumber()));

    }
}
