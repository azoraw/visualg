package com.visualg.animations.qtree.qTree1;

import com.visualg.animations.noise.transparent.Colors;
import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.qtree.qTree1.Settings.INSTANCE;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("number of particles")
                .initValue(INSTANCE.getNumberOfParticles())
                .onValueChange((str) -> INSTANCE.setNumberOfParticles(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("range")
                .initValue(INSTANCE.getRectSize())
                .onValueChange((str) -> INSTANCE.setRectSize(Integer.parseInt(str)))
                .afterValueChange((str)-> fire(new RestartEvent()))
                .build());
        addRow(SelectBoxRow.<QueryMode>builder()
                .label("query mode")
                .selected(INSTANCE.getMode())
                .onChange(INSTANCE::setMode)
                .items(QueryMode.values())
                .build());

           }
}
