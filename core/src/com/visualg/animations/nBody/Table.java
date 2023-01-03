package com.visualg.animations.nBody;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static java.lang.String.valueOf;

class Table extends SettingsTable {

    Table(CurrentSettings currentSettings) {

        DefaultSettingsRow g = DefaultSettingsRow.builder()
                .label("G")
                .initValue(valueOf(currentSettings.getG()))
                .onValueChange(stringValue -> currentSettings.setG(Float.parseFloat(stringValue)))
                .build();
        addRow(g);

        DefaultSettingsRow numberOfBodies = DefaultSettingsRow.builder()
                .label("number of bodies")
                .initValue(valueOf(currentSettings.getNumberOfBodies()))
                .onValueChange(stringValue -> currentSettings.setNumberOfBodies(Integer.parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBodies);
    }
}
