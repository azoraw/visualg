package com.visualg.animations.moireSuperlattice;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.moireSuperlattice.MoireSuperLatticeSettings.settings;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(settings.getTransparency())
                .onValueChange((str) -> settings.setTransparency(Float.parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("moduloX")
                .initValue(settings.getModuloX())
                .onValueChange((str) -> settings.setModuloX(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("moduloY")
                .initValue(settings.getModuloY())
                .onValueChange((str) -> settings.setModuloY(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("rotationSpeed")
                .initValue(settings.getRotationSpeed())
                .onValueChange((str) -> settings.setRotationSpeed(Float.parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
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
