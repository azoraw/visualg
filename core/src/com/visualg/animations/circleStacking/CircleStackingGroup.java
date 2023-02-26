package com.visualg.animations.circleStacking;

import com.badlogic.gdx.scenes.scene2d.Group;

public class CircleStackingGroup extends Group {

    public CircleStackingGroup() {
        CircleStackingSettings circleStackingSettings = CircleStackingSettings.settings;
        CircleStackingActor actor = new CircleStackingActor();
        Table settingsTable = new Table(circleStackingSettings, actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}
