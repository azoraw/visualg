package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
       HairyFlowFieldPixmapActor actor = new HairyFlowFieldPixmapActor();
        //HairyFlowFieldActor actor = new HairyFlowFieldActor();
        Table settingsTable = new Table(actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}