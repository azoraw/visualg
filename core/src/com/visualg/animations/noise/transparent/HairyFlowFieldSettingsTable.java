package com.visualg.animations.noise.transparent;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SettingsTable;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class HairyFlowFieldSettingsTable extends SettingsTable {

    public HairyFlowFieldSettingsTable(CurrentSettings settings) {


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

        /*CheckBox connected = new CheckBox("connect init point", skin);
        connected.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                settings.setConnectedWithStartingPoint(!settings.isConnectedWithStartingPoint());
            }
        });
        add(new EmptyLabel());
        add(connected);
        row();*/
    }
}
