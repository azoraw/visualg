package com.visualg.animations.noise.transparent;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.visualg.global.Config.HEIGHT;
import static com.visualg.global.Config.WIDTH;

public class HairyFlowFieldGroup extends Group {

    public HairyFlowFieldGroup() {
        HairyFlowFieldPixmapActor actor = new HairyFlowFieldPixmapActor(WIDTH, HEIGHT);
       // HairyFlowFieldActor actor = new HairyFlowFieldActor();
        Table settingsTable = new Table(actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}