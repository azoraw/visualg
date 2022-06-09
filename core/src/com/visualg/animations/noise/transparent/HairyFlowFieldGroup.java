package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
        CurrentSettings settings = CurrentSettings.INSTANCE;
        HairyFlowFieldSettingsTable settingsTable = new HairyFlowFieldSettingsTable(settings);
        this.addActor(new HairyFlowFieldActor(settings));
        this.addActor(settingsTable);
    }
}