package com.visualg.animations.noise.simplex;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.util.libgdx.ui.simplifiedComponents.EmptyLabel;

import static java.lang.String.valueOf;

public class NoiseSettingsTable extends SettingsTable {
    public NoiseSettingsTable(NoiseSettings settings) {
        DefaultSettingsRow numberOfSkippedPixels = DefaultSettingsRow.builder()
                .label("pixels per cell")
                .initValue(valueOf(settings.getNumberOfSkippedPixels()))
                .onValueChange(newValue -> settings.setNumberOfSkippedPixels(Integer.parseInt(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(numberOfSkippedPixels);

        DefaultSettingsRow x = DefaultSettingsRow.builder()
                .label("X")
                .initValue(valueOf(settings.getX_OFF()))
                .onValueChange(newValue -> settings.setX_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(x);

        DefaultSettingsRow y = DefaultSettingsRow.builder()
                .label("Y")
                .initValue(valueOf(settings.getY_OFF()))
                .onValueChange(newValue -> settings.setY_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(y);

        DefaultSettingsRow z = DefaultSettingsRow.builder()
                .label("Z")
                .initValue(valueOf(settings.getZ_OFF()))
                .onValueChange(newValue -> settings.setZ_OFF(Double.parseDouble(newValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();

        addRow(z);

        DefaultCheckBox connected = DefaultCheckBox.builder()
                .label("GRAY SCALE")
                .initValue(settings.getColorMode() == SimplexColorMode.GRAYSCALE)
                .onClick(() -> {
                    settings.changeColorMode();
                    fire(new RestartEvent());
                }).build();
        add(new EmptyLabel());
        add(connected);
        row();

    }
}
