package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
        Settings settings = Settings.INSTANCE;
        HairyFlowFieldActor actor = new HairyFlowFieldActor(settings);
        Table settingsTable = new Table(settings, actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}