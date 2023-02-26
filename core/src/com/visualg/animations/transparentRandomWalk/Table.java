package com.visualg.animations.transparentRandomWalk;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.transparentRandomWalk.TransparentRandomWalkSettings.settings;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table() {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(settings.getTransparency())
                .onValueChange((str) -> settings.setTransparency(parseFloat(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("cellSize")
                .initValue(settings.getCellSize())
                .onValueChange((str) -> settings.setCellSize(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("shapeSize")
                .initValue(settings.getShapeSize())
                .onValueChange((str) -> settings.setShapeSize(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build());
        addRow(SelectBoxRow.<Shape>builder()
                .label("shape")
                .onChange(settings::setShape)
                .selected(settings.getShape())
                .items(Shape.values())
                .build());
    }
}
