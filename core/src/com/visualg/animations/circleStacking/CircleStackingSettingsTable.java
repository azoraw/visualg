package com.visualg.animations.circleStacking;

import com.visualg.menu.RestartEvent;
import com.visualg.util.MutablePair;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultButton;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class CircleStackingSettingsTable extends SettingsTable {

    public CircleStackingSettingsTable(CircleStackingSettings settings, Runnable screenshot) {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(settings.getTransparency())
                .onValueChange(newValue -> settings.setTransparency(parseFloat(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build());

        addRow(DefaultSettingsRow.builder()
                .label("numberOfCircles")
                .initValue(settings.getNumberOfCircles())
                .onValueChange(newValue -> settings.setNumberOfCircles(parseInt(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build());

        for (int i = 0; i < settings.getNumberOfCircles(); i++) {
            MutablePair<Integer, Integer> circle = settings.getCircles().get(i);
            addRow(DefaultSettingsRow.builder()
                    .label("radius" + (i + 1))
                    .initValue(circle.first)
                    .onValueChange(newValue -> circle.first = (parseInt(newValue)))
                    .afterValueChange(stringValue -> fire(new RestartEvent()))
                    .build());
            addRow(DefaultSettingsRow.builder()
                    .label("stepNo" + (i + 1))
                    .initValue(circle.second)
                    .onValueChange(newValue -> circle.second = (parseInt(newValue)))
                    .afterValueChange(stringValue -> fire(new RestartEvent()))
                    .build());
        }
        add(new DefaultButton("randomise", () -> {
            settings.randomise();
            fire(new RestartEvent());
        }));
        add(new DefaultButton("screenshot", screenshot));
    }
}
