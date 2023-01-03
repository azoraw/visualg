package com.visualg.animations.wigglyCircle;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.DefaultTextField;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class Table extends SettingsTable {


    Table(Settings settings) {

        DefaultCheckBox threshold = DefaultCheckBox.builder()
                .label("threshold")
                .initValue(settings.isThresholdEnabled())
                .onClick(() -> settings.setThresholdEnabled(!settings.isThresholdEnabled()))
                .build();
        add(threshold);
        row();

        Label maxDeltaRadius = new Label("max delta radius", skin);
        add(maxDeltaRadius);
        TextField maxDeltaRadiusTextField = new DefaultTextField(valueOf(settings.getMaxRadius()),
                stringValue -> settings.setMaxRadius(Integer.parseInt(stringValue)));
        add(maxDeltaRadiusTextField);
        row();

        Label vertexNumber = new Label("vertexNumber", skin);
        add(vertexNumber);
        TextField vertexNumberTextField = new DefaultTextField(valueOf(settings.getVertexNumber()),
                e -> settings.setVertexNumber(Integer.parseInt(e)));
        add(vertexNumberTextField);
        row();

        Label startingRadius = new Label("startingRadius", skin);
        add(startingRadius);
        TextField startingRadiusTextField = new DefaultTextField(valueOf(settings.getStartingRadius()), e -> settings.setStartingRadius(Integer.parseInt(e)));
        add(startingRadiusTextField);
        row();

        Label changeSpeed = new Label("changeSpeed", skin);
        add(changeSpeed);
        TextField changeSpeedTextField = new DefaultTextField(valueOf(settings.getZDelta()), e -> settings.setZDelta(Float.parseFloat(e)));
        add(changeSpeedTextField);
        row();

        Label noiseCos = new Label("noiseCos", skin);
        add(noiseCos);
        TextField noiseCosTextField = new DefaultTextField(valueOf(settings.getNoiseDeltaX()), e -> settings.setNoiseDeltaX(Float.parseFloat(e)));
        add(noiseCosTextField);
        row();

        Label noiseSin = new Label("noiseSin", skin);
        add(noiseSin);
        TextField noiseSinTextField = new DefaultTextField(valueOf(settings.getNoiseDeltaY()), e -> settings.setNoiseDeltaY(Float.parseFloat(e)));
        add(noiseSinTextField);
        row();
    }
}
