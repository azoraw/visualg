package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.DefaultTextField;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class Table extends SettingsTable {


    Table(WigglyCircleSettings wigglyCircleSettings) {

        DefaultCheckBox threshold = DefaultCheckBox.builder()
                .label("threshold")
                .initValue(wigglyCircleSettings.isThresholdEnabled())
                .onClick(() -> wigglyCircleSettings.setThresholdEnabled(!wigglyCircleSettings.isThresholdEnabled()))
                .build();
        add(threshold);
        row();

        Label maxDeltaRadius = new Label("max delta radius", skin);
        add(maxDeltaRadius);
        TextField maxDeltaRadiusTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getMaxRadius()),
                stringValue -> wigglyCircleSettings.setMaxRadius(Integer.parseInt(stringValue)));
        add(maxDeltaRadiusTextField);
        row();

        Label vertexNumber = new Label("vertexNumber", skin);
        add(vertexNumber);
        TextField vertexNumberTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getVertexNumber()),
                e -> wigglyCircleSettings.setVertexNumber(Integer.parseInt(e)));
        add(vertexNumberTextField);
        row();

        Label startingRadius = new Label("startingRadius", skin);
        add(startingRadius);
        TextField startingRadiusTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getStartingRadius()), e -> wigglyCircleSettings.setStartingRadius(Integer.parseInt(e)));
        add(startingRadiusTextField);
        row();

        Label changeSpeed = new Label("changeSpeed", skin);
        add(changeSpeed);
        TextField changeSpeedTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getZDelta()), e -> wigglyCircleSettings.setZDelta(Float.parseFloat(e)));
        add(changeSpeedTextField);
        row();

        Label noiseCos = new Label("noiseCos", skin);
        add(noiseCos);
        TextField noiseCosTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getNoiseDeltaX()), e -> wigglyCircleSettings.setNoiseDeltaX(Float.parseFloat(e)));
        add(noiseCosTextField);
        row();

        Label noiseSin = new Label("noiseSin", skin);
        add(noiseSin);
        TextField noiseSinTextField = new DefaultTextField(valueOf(wigglyCircleSettings.getNoiseDeltaY()), e -> wigglyCircleSettings.setNoiseDeltaY(Float.parseFloat(e)));
        add(noiseSinTextField);
        row();
    }
}
