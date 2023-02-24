package com.visualg.animations.lsystems;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

import java.util.Map;

import static com.visualg.animations.lsystems.Settings.Settings;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table(Runnable onScreenShot) {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(Settings.transparency)
                .onValueChange(str -> {
                    Settings.setTransparency(parseFloat(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("numberOfGenerations")
                .initValue(Settings.numberOfGenerations)
                .onValueChange(str -> {
                    Settings.setNumberOfGenerations(parseInt(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("xStart")
                .initValue(Settings.xStart)
                .onValueChange(str -> {
                    Settings.setXStart(parseInt(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("yStart")
                .initValue(Settings.yStart)
                .onValueChange(str -> {
                    Settings.setYStart(parseInt(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("angleStart")
                .initValue(Settings.angleStart)
                .onValueChange(str -> {
                    Settings.setAngleStart(parseInt(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("distance")
                .initValue(Settings.distance)
                .onValueChange(str -> {
                    Settings.setDistance(parseFloat(str));
                    fire(new RestartEvent());
                }).build());
        addRow(SelectBoxRow.<LSystem>builder()
                .label("lSystem")
                .onChange(lSystem -> {
                    Settings.setLSystem(lSystem);
                    Settings.restart();
                    fire(new RestartEvent());
                })
                .selected(Settings.getLSystem())
                .items(LSystem.values())
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("rotateLeft")
                .initValue(Settings.rotateLeft)
                .onValueChange(str -> {
                    Settings.setRotateLeft(parseFloat(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("rotateRight")
                .initValue(Settings.rotateRight)
                .onValueChange(str -> {
                    Settings.setRotateRight(parseFloat(str));
                    fire(new RestartEvent());
                }).build());
        addRow(DefaultSettingsRow.builder()
                .label("axiom")
                .initValue(Settings.axiom)
                .onValueChange(str -> {
                    Settings.setAxiom(str);
                    fire(new RestartEvent());
                }).build());
        for (Map.Entry<Character, String> ruleEntry : Settings.rules.entrySet()) {
            addRow(DefaultSettingsRow.builder()
                    .label("key")
                    .initValue(ruleEntry.getKey())
                    .onValueChange(str -> {
                        String value = Settings.rules.remove(ruleEntry.getKey());
                        Settings.rules.put(str.charAt(0), value);
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
