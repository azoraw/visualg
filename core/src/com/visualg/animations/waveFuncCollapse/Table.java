package com.visualg.animations.waveFuncCollapse;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

class Table extends SettingsTable {

    public Table(WFCActor actor) {
        Settings settings = Settings.INSTANCE;
        addRow(SelectBoxRow.<Variant>builder()
                .label("variants")
                .onChange(variant -> {
                    settings.setVariant(variant);
                    fire(new RestartEvent());
                })
                .selected(settings.getVariant())
                .items(Variant.values())
                .build());
        add(new EmptyLabel());
        add(new DefaultButton("screenShot", actor::takeScreenShot));
    }
}
