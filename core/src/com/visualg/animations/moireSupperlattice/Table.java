package com.visualg.animations.moireSupperlattice;

import com.visualg.animations.bezier.BlobColor;
import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;

import static com.visualg.animations.moireSupperlattice.Settings.INSTANCE;

class Table extends SettingsTable {
    Table() {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(INSTANCE.getTransparency())
                .onValueChange((str) -> INSTANCE.setTransparency(Float.parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("moduloX")
                .initValue(INSTANCE.getModuloX())
                .onValueChange((str) -> INSTANCE.setModuloX(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("moduloY")
                .initValue(INSTANCE.getModuloY())
                .onValueChange((str) -> INSTANCE.setModuloY(Integer.parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("rotationSpeed")
                .initValue(INSTANCE.getRotationSpeed())
                .onValueChange((str) -> INSTANCE.setRotationSpeed(Float.parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(SelectBoxRow.<ColorOption>builder()
                .label("colorOption")
                .onChange(colorOption -> {
                    INSTANCE.setColorOption(colorOption);
                    fire(new RestartEvent());
                })
                .selected(INSTANCE.getColorOption())
                .items(ColorOption.values())
                .build());
        addRow(SelectBoxRow.<ColorOption>builder()
                .label("colorOption2")
                .onChange(colorOption -> {
                    INSTANCE.setColorOption2(colorOption);
                    fire(new RestartEvent());
                })
                .selected(INSTANCE.getColorOption2())
                .items(ColorOption.values())
                .build());
    }

}
