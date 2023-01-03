package com.visualg.animations.transparentRandomWalk;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.transparentRandomWalk.Settings.INSTANCE;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table() {
        addRow(DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(INSTANCE.getTransparency())
                .onValueChange((str)-> INSTANCE.setTransparency(parseFloat(str)))
                .afterValueChange((str) ->fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("cellSize")
                .initValue(INSTANCE.getCellSize())
                .onValueChange((str)-> INSTANCE.setCellSize(parseInt(str)))
                .afterValueChange((str) ->fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("shapeSize")
                .initValue(INSTANCE.getShapeSize())
                .onValueChange((str)-> INSTANCE.setShapeSize(parseInt(str)))
                .afterValueChange((str) ->fire(new RestartEvent()))
                .build());
        addRow(SelectBoxRow.<Shape>builder()
                .label("shape")
                .onChange(INSTANCE::setShape)
                .selected(INSTANCE.getShape())
                .items(Shape.values())
                .build());
    }
}
