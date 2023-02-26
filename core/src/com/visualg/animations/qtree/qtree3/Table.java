package com.visualg.animations.qtree.qtree3;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("movementSpeed")
                .initValue(QTree3Settings.settings.getMovementSpeed())
                .onValueChange((str) -> QTree3Settings.settings.setMovementSpeed(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(QTree3Settings.settings.getNumberOfParticles())
                .onValueChange((str) -> QTree3Settings.settings.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("particle range")
                .initValue(QTree3Settings.settings.getRectSize())
                .onValueChange((str) -> QTree3Settings.settings.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
    }
}
