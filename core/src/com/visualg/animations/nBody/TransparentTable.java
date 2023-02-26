package com.visualg.animations.nBody;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.nBody.NBodySettings.settings;
import static java.lang.Float.parseFloat;
import static java.lang.String.valueOf;

class TransparentTable extends SettingsTable {

    TransparentTable() {
        DefaultSettingsRow g = DefaultSettingsRow.builder()
                .label("G")
                .initValue(valueOf(settings.getG()))
                .onValueChange(stringValue -> settings.setG(parseFloat(stringValue)))
                .build();
        addRow(g);

        DefaultSettingsRow numberOfBodies = DefaultSettingsRow.builder()
                .label("number of bodies")
                .initValue(valueOf(settings.getNumberOfBodies()))
                .onValueChange(stringValue -> settings.setNumberOfBodies(Integer.parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBodies);

        DefaultSettingsRow transparency = DefaultSettingsRow.builder()
                .label("transparency")
                .initValue(valueOf(settings.getTransparency()))
                .onValueChange(stringValue -> settings.setTransparency(parseFloat(stringValue)))
                .build();
        addRow(transparency);
    }
}
