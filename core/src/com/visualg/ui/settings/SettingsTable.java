package com.visualg.ui.settings;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;
import static com.visualg.global.Config.skin;

public class SettingsTable extends Table {

    public SettingsTable() {
        setSize(WIDTH, HEIGHT);
        top().right();
        Label empty = new Label("", skin);
        add(empty);
        row();

        Label settings = new Label("Settings", skin);
        add(settings);
        row();
    }

    protected void addRow(SettingsRow settingsRow) {
        add(settingsRow.getLabel());
        add(settingsRow.getWidget());
        row();
    }
}
