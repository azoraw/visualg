package com.visualg.animations.qtree.qTree1;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(Settings.INSTANCE.getNumberOfParticles())
                .onValueChange((str) -> Settings.INSTANCE.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("range")
                .initValue(Settings.INSTANCE.getRectSize())
                .onValueChange((str) -> Settings.INSTANCE.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
    }
}
