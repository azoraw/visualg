package com.visualg.animations.mondrian;

import com.badlogic.gdx.scenes.scene2d.Group;

public class MondrianGroup extends Group {
    public MondrianGroup() {
        MondrianActor actor = new MondrianActor();
        Table settingsTable = new Table(actor);
        addActor(actor);
        addActor(settingsTable);
    }
}
