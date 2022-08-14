package com.visualg.animations.circleStacking;

import com.badlogic.gdx.scenes.scene2d.Group;

public class CircleStackingGroup extends Group {

    public CircleStackingGroup() {
        CircleStackingSettings settings = CircleStackingSettings.INSTANCE;
        CircleStackingActor actor = new CircleStackingActor();
        CircleStackingSettingsTable settingsTable = new CircleStackingSettingsTable(settings, actor.onScreenShot());
        addActor(actor);
        addActor(settingsTable);
    }
}
