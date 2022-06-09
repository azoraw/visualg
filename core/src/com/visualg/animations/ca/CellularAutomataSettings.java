package com.visualg.animations.ca;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class CellularAutomataSettings extends SettingsTable {

    private final TextField ruleNumberTextField;
    private final CurrentSettings currentSettings;

    CellularAutomataSettings(CurrentSettings currentSettings) {
        this.currentSettings = currentSettings;

        DefaultSettingsRow ruleNumber = DefaultSettingsRow.builder()
                .label("Rule number")
                .initValue(valueOf(currentSettings.getRuleNumber()))
                .onValueChange(newStringValue -> currentSettings.setRuleNumber(parseInt(newStringValue)))
                .afterValueChange(newStringValue -> fire(new RestartEvent()))
                .build();

        ruleNumberTextField = ruleNumber.getTextField();
        addRow(ruleNumber);

        DefaultSettingsRow animationSpeed = DefaultSettingsRow.builder()
                .label("Animation speed")
                .initValue(valueOf(currentSettings.getAnimationSpeedInSec()))
                .onValueChange(newStringValue -> currentSettings.setAnimationSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(animationSpeed);

        DefaultSettingsRow ruleChangeSpeed = DefaultSettingsRow.builder()
                .label("Rule change speed")
                .initValue(valueOf(currentSettings.getRuleChangeSpeedInSec()))
                .onValueChange(newStringValue -> currentSettings.setRuleChangeSpeedInSec(Float.parseFloat(newStringValue)))
                .build();
        addRow(ruleChangeSpeed);
    }


    void updateRuleNumber() {
        ruleNumberTextField.setText(valueOf(currentSettings.getRuleNumber()));

    }
}
