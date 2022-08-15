package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.util.libgdx.ui.SettingsTable;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultTextField;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class WigglyCircleSettingsTable extends SettingsTable {


    public WigglyCircleSettingsTable(CurrentSettings currentSettings) {

        DefaultCheckBox threshold = DefaultCheckBox.builder()
                .label("threshold")
                .initValue(currentSettings.isThresholdEnabled())
                .onClick(() -> currentSettings.setThresholdEnabled(!currentSettings.isThresholdEnabled()))
                .build();
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
