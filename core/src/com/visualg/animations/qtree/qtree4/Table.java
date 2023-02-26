package com.visualg.animations.qtree.qtree4;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("movementSpeed")
                .initValue(Qtree4Settings.settings.getMovementSpeed())
                .onValueChange((str) -> Qtree4Settings.settings.setMovementSpeed(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(Qtree4Settings.settings.getNumberOfParticles())
                .onValueChange((str) -> Qtree4Settings.settings.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("particle range")
                .initValue(Qtree4Settings.settings.getRectSize())
                .onValueChange((str) -> Qtree4Settings.settings.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
    }
}
