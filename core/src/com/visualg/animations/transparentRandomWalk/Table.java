package com.visualg.animations.transparentRandomWalk;

import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.transparentRandomWalk.TransparentRandomWalkSettings.settings;

class Table extends SettingsTable {
    public Table() {
        addNumericRows(settings);
        addRow(SelectBoxRow.<Shape>builder()
                .label("shape")
                .onChange(settings::setShape)
                .selected(settings.getShape())
                .items(Shape.values())
                .build());
    }
}
