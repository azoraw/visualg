package com.visualg.animations.lissajous;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.lissajous.Settings.INSTANCE;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table() {
        addRow(DefaultSettingsRow.builder()
                .label("A")
                .initValue(INSTANCE.getA())
                .onValueChange((str) -> INSTANCE.setA(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("B")
                .initValue(INSTANCE.getB())
                .onValueChange((str) -> INSTANCE.setB(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("PIMultiplierX")
                .initValue(INSTANCE.getPIMultiplierX())
                .onValueChange((str) -> INSTANCE.setPIMultiplierX(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("PIMultiplierY")
                .initValue(INSTANCE.getPIMultiplierY())
                .onValueChange((str) -> INSTANCE.setPIMultiplierY(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("timeStep")
                .initValue(INSTANCE.getTimeStep())
                .onValueChange((str) -> INSTANCE.setTimeStep(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("lineThickness")
                .initValue(INSTANCE.getLineThickness())
                .onValueChange((str) -> INSTANCE.setLineThickness(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(INSTANCE.getTransparency())
                .onValueChange((str) -> INSTANCE.setTransparency(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
    }
}
