package com.visualg.animations.qtree3;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

public class Table extends SettingsTable {
    public Table() {
        addRow(DefaultSettingsRow.builder()
                .label("movementSpeed")
                .initValue(Settings.INSTANCE.getMovementSpeed())
                .onValueChange((str) -> Settings.INSTANCE.setMovementSpeed(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(Settings.INSTANCE.getNumberOfParticles())
                .onValueChange((str) -> Settings.INSTANCE.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("particle range")
                .initValue(Settings.INSTANCE.getRectSize())
                .onValueChange((str) -> Settings.INSTANCE.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
    }
}
