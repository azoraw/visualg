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

        DefaultSettingsRow scale = DefaultSettingsRow.builder()
                .label("scale")
                .initValue(valueOf(settings.getScale()))
                .onValueChange(stringValue -> settings.setScale(parseInt(stringValue)))
                .afterValueChange(stringValue -> fire(new RestartEvent()))
                .build();
        addRow(scale);

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
                .onChange(colors -> {
                    settings.setColors(colors);
                    fire(new RestartEvent());
                })
                .selected(settings.getColors())
                .items(Colors.values())
                .build());

        DefaultButton screenShot = new DefaultButton("screenShot", onScreenShotRunnable);
        add(new EmptyLabel());
        add(screenShot);
    }
}
