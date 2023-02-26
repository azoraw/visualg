package com.visualg.animations.qtree.qTree1;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.qtree.qTree1.QTree1Settings.settings;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(settings.getNumberOfParticles())
                .onValueChange((str) -> settings.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("range")
                .initValue(settings.getRectSize())
                .onValueChange((str) -> settings.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(SelectBoxRow.<QueryMode>builder()
                .label("query mode")
                .selected(settings.getMode())
                .onChange(settings::setMode)
                .items(QueryMode.values())
                .build());

    }
}
