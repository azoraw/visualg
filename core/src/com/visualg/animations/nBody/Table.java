package com.visualg.animations.nBody;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.nBody.NBodySettings.settings;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    Table() {

        DefaultSettingsRow g = DefaultSettingsRow.builder()
                .label("G")
                .initValue(valueOf(settings.getG()))
                .onValueChange(stringValue -> settings.setG(Float.parseFloat(stringValue)))
                .build();
        addRow(g);

        DefaultSettingsRow numberOfBodies = DefaultSettingsRow.builder()
                .label("number of bodies")
                .initValue(valueOf(settings.getNumberOfBodies()))
                .onValueChange(stringValue -> {
                    settings.setNumberOfBodies(Integer.parseInt(stringValue));
                    fire(new RestartEvent());
                })
                .build();
        addRow(numberOfBodies);
    }
}
