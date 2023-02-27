package com.visualg.animations.noise.simplex;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static com.visualg.animations.noise.simplex.SimplexSettings.settings;

class Table extends SettingsTable {
    Table() {
        addNumericRows(settings);

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
