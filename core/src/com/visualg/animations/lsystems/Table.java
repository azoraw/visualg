package com.visualg.animations.lsystems;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

import java.util.Map;

import static com.visualg.animations.lsystems.LSystemSettings.LSystemSettings;

class Table extends SettingsTable {
    public Table(Runnable onScreenShot) {
        addNumericRows(LSystemSettings);
        addRow(SelectBoxRow.<LSystem>builder()
                .label("lSystem")
                .onChange(lSystem -> {
                    LSystemSettings.setLSystem(lSystem);
                    LSystemSettings.restart();
                    fire(new RestartEvent());
                })
                .selected(LSystemSettings.getLSystem())
                .items(LSystem.values())
                .build());
        for (Map.Entry<Character, String> ruleEntry : LSystemSettings.rules.entrySet()) {
            addRow(DefaultSettingsRow.builder()
                    .label("key")
                    .initValue(ruleEntry.getKey())
                    .onValueChange(str -> {
                        String value = LSystemSettings.rules.remove(ruleEntry.getKey());
                        LSystemSettings.rules.put(str.charAt(0), value);
                        fire(new RestartEvent());
                    }).build());
            addRow(DefaultSettingsRow.builder()
                    .label("value")
                    .initValue(ruleEntry.getValue())
                    .onValueChange(str -> {
                        ruleEntry.setValue(str);
                        fire(new RestartEvent());
                    }).build());
        }

        add(new DefaultButton("screenShot", onScreenShot));
    }
}
