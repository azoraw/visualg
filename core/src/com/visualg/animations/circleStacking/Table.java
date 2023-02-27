package com.visualg.animations.circleStacking;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.util.MutablePair;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {

    Table(CircleStackingSettings circleStackingSettings, Runnable screenshot) {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(circleStackingSettings.getTransparency())
                .onValueChange(newValue -> {
                    circleStackingSettings.setTransparency(parseFloat(newValue));
                    fire(new RestartEvent());
                })
                .build());

        addRow(DefaultSettingsRow.builder()
                .label("numberOfCircles")
                .initValue(circleStackingSettings.getNumberOfCircles())
                .onValueChange(newValue -> {
                    circleStackingSettings.setNumberOfCircles(parseInt(newValue));
                    fire(new RestartEvent());
                })
                .build());

        for (int i = 0; i < circleStackingSettings.getNumberOfCircles(); i++) {
            MutablePair<Integer, Integer> circle = circleStackingSettings.getCircles().get(i);
            addRow(DefaultSettingsRow.builder()
                    .label("radius" + (i + 1))
                    .initValue(circle.first)
                    .onValueChange(newValue -> {
                        circle.first = (parseInt(newValue));
                        fire(new RestartEvent());
                    })
                    .build());
            addRow(DefaultSettingsRow.builder()
                    .label("stepNo" + (i + 1))
                    .initValue(circle.second)
                    .onValueChange(newValue -> {
                        circle.second = (parseInt(newValue));
                        fire(new RestartEvent());
                    })
                    .build());
        }
        add(new DefaultButton("randomise", () -> {
            circleStackingSettings.randomise();
            fire(new RestartEvent());
        }));
        add(new DefaultButton("screenshot", screenshot));
    }
}
