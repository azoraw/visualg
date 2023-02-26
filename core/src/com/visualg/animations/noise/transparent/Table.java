package com.visualg.animations.noise.transparent;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

class Table extends SettingsTable {

    Table(TransparentSettings transparentSettings, Runnable onScreenShotRunnable) {

        DefaultSettingsRow alpha = DefaultSettingsRow.builder()
                .label("alpha")
                .initValue(valueOf(transparentSettings.getAlpha()))
                .onValueChange(stringValue -> transparentSettings.setAlpha(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(alpha);

        DefaultSettingsRow numberOfAgents = DefaultSettingsRow.builder()
                .label("numberOfAgents")
                .initValue(valueOf(transparentSettings.getNumberOfAgents()))
                .onValueChange(stringValue -> transparentSettings.setNumberOfAgents(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(numberOfAgents);

        DefaultSettingsRow tiles = DefaultSettingsRow.builder()
                .label("tiles")
                .initValue(valueOf(transparentSettings.getTiles()))
                .onValueChange(stringValue -> transparentSettings.setTiles(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(tiles);

        DefaultSettingsRow initFrameSkips = DefaultSettingsRow.builder()
                .label("initFrameSkips")
                .initValue(valueOf(transparentSettings.getInitFrameSkips()))
                .onValueChange(stringValue -> transparentSettings.setInitFrameSkips(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(initFrameSkips);

        DefaultSettingsRow fieldForce = DefaultSettingsRow.builder()
                .label("fieldForce")
                .initValue(valueOf(transparentSettings.getFieldMagnitude()))
                .onValueChange(stringValue -> transparentSettings.setFieldMagnitude(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(fieldForce);

        DefaultSettingsRow step = DefaultSettingsRow.builder()
                .label("step")
                .initValue(valueOf(transparentSettings.getStep()))
                .onValueChange(stringValue -> transparentSettings.setStep(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(step);

        DefaultCheckBox connected = DefaultCheckBox.builder()
                .label("connect init point")
                .initValue(transparentSettings.isConnectedWithStartingPoint())
                .onClick(() -> transparentSettings.setConnectedWithStartingPoint(!transparentSettings.isConnectedWithStartingPoint()))
                .build();
        add(new EmptyLabel());
        add(connected);
        row();
        DefaultCheckBox haveMiddleCircle = DefaultCheckBox.builder()
                .label("have middle circle")
                .initValue(transparentSettings.isHaveMiddleCircle())
                .onClick(() -> {
                    transparentSettings.setHaveMiddleCircle(!transparentSettings.isHaveMiddleCircle());
                    fire(new RestartEvent());

                })
                .build();
        add(new EmptyLabel());
        add(haveMiddleCircle);
        row();

        addRow(SelectBoxRow.<Colors>builder()
                .label("colours")
                .selected(transparentSettings.getColors())
                .onChange(colors -> {
                    transparentSettings.setColors(colors);
                    fire(new RestartEvent());
                })
                .items(Colors.values())
                .build());

        addRow(SelectBoxRow.<ColorInputSrc>builder()
                .label("colours input")
                .selected(transparentSettings.getColorInputSrc())
                .onChange(colors -> {
                    transparentSettings.setColorInputSrc(colors);
                    fire(new RestartEvent());
                })
                .items(ColorInputSrc.values())
                .build());

        DefaultButton screenShot = new DefaultButton("screenShot", onScreenShotRunnable);
        add(new EmptyLabel());
        add(screenShot);
    }
}
