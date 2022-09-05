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

class HairyFlowFieldSettingsTable extends SettingsTable {

    HairyFlowFieldSettingsTable(CurrentSettings settings, Runnable onScreenShotRunnable) {

        DefaultSettingsRow alpha = DefaultSettingsRow.builder()
                .label("alpha")
                .initValue(valueOf(settings.getAlpha()))
                .onValueChange(stringValue -> settings.setAlpha(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(alpha);

        DefaultSettingsRow numberOfAgents = DefaultSettingsRow.builder()
                .label("numberOfAgents")
                .initValue(valueOf(settings.getNumberOfAgents()))
                .onValueChange(stringValue -> settings.setNumberOfAgents(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(numberOfAgents);

        DefaultSettingsRow initFrameSkips = DefaultSettingsRow.builder()
                .label("initFrameSkips")
                .initValue(valueOf(settings.getInitFrameSkips()))
                .onValueChange(stringValue -> settings.setInitFrameSkips(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(initFrameSkips);

        DefaultSettingsRow fieldForce = DefaultSettingsRow.builder()
                .label("fieldForce")
                .initValue(valueOf(settings.getFieldMagnitude()))
                .onValueChange(stringValue -> settings.setFieldMagnitude(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(fieldForce);

        DefaultSettingsRow step = DefaultSettingsRow.builder()
                .label("step")
                .initValue(valueOf(settings.getStep()))
                .onValueChange(stringValue -> settings.setStep(parseFloat(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(step);

        DefaultCheckBox connected = DefaultCheckBox.builder()
                .label("connect init point")
                .initValue(settings.isConnectedWithStartingPoint())
                .onClick(() -> settings.setConnectedWithStartingPoint(!settings.isConnectedWithStartingPoint()))
                .build();
        add(new EmptyLabel());
        add(connected);
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
