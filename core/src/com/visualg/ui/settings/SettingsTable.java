package com.visualg.ui.settings;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class SettingsTable extends Table {

    public SettingsTable() {
        setSize(WIDTH, HEIGHT);
        top().right();
        emptyRow();
        emptyRow();
        add(new DefaultLabel("Settings"));
        row();
    }

    private void emptyRow() {
        add(new EmptyLabel());
        row();
    }

    protected void addRow(SettingsRow settingsRow) {
        add(settingsRow.getLabel());
        add(settingsRow.getWidget());
        row();
    }
}
