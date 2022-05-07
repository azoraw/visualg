package com.visualg.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import static com.visualg.global.Config.skin;

public class SettingsTable extends Table {

    public SettingsTable() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        top().right();
        Label empty = new Label("", skin);
        add(empty);
        row();

        Label settings = new Label("Settings", skin);
        add(settings);
        row();
    }

    protected void addRow(DefaultSettingsRow defaultSettingsRow) {
        add(defaultSettingsRow.getLabel());
        add(defaultSettingsRow.getTextField());
        row();
    }
}
