package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
        CurrentSettings settings = CurrentSettings.INSTANCE;
        HairyFlowFieldActor actor = new HairyFlowFieldActor(settings);
        HairyFlowFieldSettingsTable settingsTable = new HairyFlowFieldSettingsTable(settings, actor.onScreenShot());
        this.addActor(actor);
        this.addActor(settingsTable);
    }
}