package com.visualg.animations.nBody;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.menu.RestartEvent;
import com.visualg.ui.DefaultTextField;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class NBodySettingsTable extends Table {

    private final CurrentSettings currentSettings;

    NBodySettingsTable(CurrentSettings currentSettings) {
        this.currentSettings = currentSettings;
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        top().right();
        Label empty = new Label("", skin);
        add(empty);
        row();

        Label settings = new Label("Settings", skin);
        add(settings);
        row();

        Label g = new Label("G", skin);
        add(g);
        TextField gTextField = new DefaultTextField(valueOf(currentSettings.getG()),
                stringValue -> currentSettings.setG(Float.parseFloat(stringValue)));
        add(gTextField);
        row();

        Label maxDeltaRadius = new Label("number of bodies", skin);
        add(maxDeltaRadius);
        TextField maxDeltaRadiusTextField = new DefaultTextField(valueOf(currentSettings.getNumberOfBodies()),
                stringValue -> {
                    currentSettings.setNumberOfBodies(Integer.parseInt(stringValue));
                    fire(new RestartEvent());
                });
        add(maxDeltaRadiusTextField);
        row();
    }
}
