package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.visualg.ui.DefaultTextField;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class WigglyCircleSettings extends Table {

    private final CurrentSettings currentSettings;

    public WigglyCircleSettings(CurrentSettings currentSettings) {
        this.currentSettings = currentSettings;
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        top().right();
        Label empty = new Label("", skin);
        add(empty);
        row();

        Label settings = new Label("Settings", skin);
        add(settings);
        row();

        CheckBox threshold = new CheckBox("threshold", skin);
        threshold.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentSettings.setThresholdEnabled(!currentSettings.isThresholdEnabled());
            }
        });
        add(threshold);
        row();

        Label maxDeltaRadius = new Label("max delta radius", skin);
        add(maxDeltaRadius);
        TextField maxDeltaRadiusTextField = new DefaultTextField(valueOf(currentSettings.getMaxRadius()),
                stringValue -> currentSettings.setMaxRadius(Integer.parseInt(stringValue)));
        add(maxDeltaRadiusTextField);
        row();

        Label vertexNumber = new Label("vertexNumber", skin);
        add(vertexNumber);
        TextField vertexNumberTextField = new DefaultTextField(valueOf(currentSettings.getVertexNumber()),
                e -> currentSettings.setVertexNumber(Integer.parseInt(e)));

        add(vertexNumberTextField);
        row();

        Label startingRadius = new Label("startingRadius", skin);
        add(startingRadius);
        TextField startingRadiusTextField = new DefaultTextField(valueOf(currentSettings.getStartingRadius()), e -> currentSettings.setStartingRadius(Integer.parseInt(e)));
        add(startingRadiusTextField);
        row();

        Label changeSpeed = new Label("changeSpeed", skin);
        add(changeSpeed);
        TextField changeSpeedTextField = new DefaultTextField(valueOf(currentSettings.getZDelta()), e -> currentSettings.setZDelta(Float.parseFloat(e)));
        add(changeSpeedTextField);
        row();

        Label noiseCos = new Label("noiseCos", skin);
        add(noiseCos);
        TextField noiseCosTextField = new DefaultTextField(valueOf(currentSettings.getNoiseDeltaX()), e -> currentSettings.setNoiseDeltaX(Float.parseFloat(e)));
        add(noiseCosTextField);
        row();

        Label noiseSin = new Label("noiseSin", skin);
        add(noiseSin);
        TextField noiseSinTextField = new DefaultTextField(valueOf(currentSettings.getNoiseDeltaY()), e -> currentSettings.setNoiseDeltaY(Float.parseFloat(e)));
        add(noiseSinTextField);
        row();
    }
}
