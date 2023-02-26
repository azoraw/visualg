package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
        TransparentSettings transparentSettings = TransparentSettings.settings;
        HairyFlowFieldActor actor = new HairyFlowFieldActor(transparentSettings);
        Table settingsTable = new Table(transparentSettings, actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}