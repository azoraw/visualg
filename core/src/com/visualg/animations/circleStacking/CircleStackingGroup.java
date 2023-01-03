package com.visualg.animations.circleStacking;

import com.badlogic.gdx.scenes.scene2d.Group;

public class CircleStackingGroup extends Group {

    public CircleStackingGroup() {
        Settings settings = Settings.INSTANCE;
        CircleStackingActor actor = new CircleStackingActor();
        Table settingsTable = new Table(settings, actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}
