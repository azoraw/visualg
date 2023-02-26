package com.visualg.animations.lsystems;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

import java.util.Map;

import static com.visualg.animations.lsystems.LSystemSettings.settings;

class Table extends SettingsTable {
    public Table(Runnable onScreenShot) {
        addNumericRows(settings);
        addRow(SelectBoxRow.<LSystem>builder()
                .label("lSystem")
                .onChange(lSystem -> {
                    settings.setLSystem(lSystem);
                    settings.restart();
                    fire(new RestartEvent());
                })
                .selected(settings.getLSystem())
                .items(LSystem.values())
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("axiom")
                .initValue(settings.getAxiom())
                .onValueChange(str -> {
                    settings.setAxiom(str);
                    fire(new RestartEvent());
                })
                .build());
        for (Map.Entry<Character, String> ruleEntry : settings.rules.entrySet()) {
            addRow(DefaultSettingsRow.builder()
                    .label("key")
                    .initValue(ruleEntry.getKey())
                    .onValueChange(str -> {
                        String value = settings.rules.remove(ruleEntry.getKey());
                        settings.rules.put(str.charAt(0), value);
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
