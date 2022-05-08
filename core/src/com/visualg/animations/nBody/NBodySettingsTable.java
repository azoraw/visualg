package com.visualg.animations.nBody;

import com.visualg.menu.RestartEvent;
import com.visualg.ui.DefaultSettingsRow;
import com.visualg.ui.SettingsTable;

import static java.lang.String.valueOf;

class NBodySettingsTable extends SettingsTable {

    NBodySettingsTable(CurrentSettings currentSettings) {

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
