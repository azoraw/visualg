package com.visualg.animations.lissajous;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.lissajous.LissajousSettings.settings;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table() {
        addRow(DefaultSettingsRow.builder()
                .label("A")
                .initValue(settings.getA())
                .onValueChange((str) -> settings.setA(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("B")
                .initValue(settings.getB())
                .onValueChange((str) -> settings.setB(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("PIMultiplierX")
                .initValue(settings.getPIMultiplierX())
                .onValueChange((str) -> settings.setPIMultiplierX(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("PIMultiplierY")
                .initValue(settings.getPIMultiplierY())
                .onValueChange((str) -> settings.setPIMultiplierY(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("timeStep")
                .initValue(settings.getTimeStep())
                .onValueChange((str) -> settings.setTimeStep(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("lineThickness")
                .initValue(settings.getLineThickness())
                .onValueChange((str) -> settings.setLineThickness(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(settings.getTransparency())
                .onValueChange((str) -> settings.setTransparency(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
    }
}
