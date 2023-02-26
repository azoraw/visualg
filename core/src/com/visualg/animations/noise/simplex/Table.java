package com.visualg.animations.noise.simplex;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static java.lang.String.valueOf;

class Table extends SettingsTable {
    Table(SimplexSettings simplexSettings) {
        DefaultSettingsRow numberOfSkippedPixels = DefaultSettingsRow.builder()
                .label("pixels per cell")
                .initValue(valueOf(simplexSettings.getNumberOfSkippedPixels()))
                .onValueChange(newValue -> simplexSettings.setNumberOfSkippedPixels(Integer.parseInt(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(numberOfSkippedPixels);

        DefaultSettingsRow x = DefaultSettingsRow.builder()
                .label("X")
                .initValue(valueOf(simplexSettings.getX_OFF()))
                .onValueChange(newValue -> simplexSettings.setX_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(x);

        DefaultSettingsRow y = DefaultSettingsRow.builder()
                .label("Y")
                .initValue(valueOf(simplexSettings.getY_OFF()))
                .onValueChange(newValue -> simplexSettings.setY_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(y);

        DefaultSettingsRow z = DefaultSettingsRow.builder()
                .label("Z")
                .initValue(valueOf(simplexSettings.getZ_OFF()))
                .onValueChange(newValue -> simplexSettings.setZ_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(z);

        DefaultCheckBox connected = DefaultCheckBox.builder()
                .label("GRAY SCALE")
                .initValue(simplexSettings.getColorMode() == SimplexColorMode.GRAYSCALE)
                .onClick(() -> {
                    simplexSettings.changeColorMode();
                    fire(new RestartEvent());
                }).build();
        add(new EmptyLabel());
        add(connected);
        row();

    }
}
