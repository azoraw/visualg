package com.visualg.animations.moireSuperlattice;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.moireSuperlattice.MoireSuperLatticeSettings.settings;

class Table extends SettingsTable {
    Table() {
        addNumericRows(settings);
        addRow(SelectBoxRow.<ColorOption>builder()
                .label("colorOption")
                .onChange(colorOption -> {
                    settings.setColorOption(colorOption);
                    fire(new RestartEvent());
                })
                .selected(settings.getColorOption())
                .items(ColorOption.values())
                .build());
        addRow(SelectBoxRow.<ColorOption>builder()
                .label("colorOption2")
                .onChange(colorOption -> {
                    settings.setColorOption2(colorOption);
                    fire(new RestartEvent());
                })
                .selected(settings.getColorOption2())
                .items(ColorOption.values())
                .build());
    }

}
