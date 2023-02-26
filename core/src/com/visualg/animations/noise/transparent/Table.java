package com.visualg.animations.noise.transparent;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static com.visualg.animations.noise.transparent.TransparentSettings.settings;

class Table extends SettingsTable {

    Table(Runnable onScreenShotRunnable) {
        addNumericRows(settings);
        DefaultCheckBox connected = DefaultCheckBox.builder()
                .label("connect init point")
                .initValue(settings.isConnectedWithStartingPoint())
                .onClick(() -> settings.setConnectedWithStartingPoint(!settings.isConnectedWithStartingPoint()))
                .build();
        add(new EmptyLabel());
        add(connected);
        row();

        DefaultCheckBox haveMiddleCircle = DefaultCheckBox.builder()
                .label("have middle circle")
                .initValue(settings.isHaveMiddleCircle())
                .onClick(() -> {
                    settings.setHaveMiddleCircle(!settings.isHaveMiddleCircle());
                    fire(new RestartEvent());

                })
                .build();
        add(new EmptyLabel());
        add(haveMiddleCircle);
        row();

        addRow(SelectBoxRow.<Colors>builder()
                .label("colours")
                .selected(settings.getColors())
                .onChange(colors -> {
                    settings.setColors(colors);
                    fire(new RestartEvent());
                })
                .items(Colors.values())
                .build());

        addRow(SelectBoxRow.<ColorInputSrc>builder()
                .label("colours input")
                .selected(settings.getColorInputSrc())
                .onChange(colors -> {
                    settings.setColorInputSrc(colors);
                    fire(new RestartEvent());
                })
                .items(ColorInputSrc.values())
                .build());

        DefaultButton screenShot = new DefaultButton("screenShot", onScreenShotRunnable);
        add(new EmptyLabel());
        add(screenShot);
    }
}
