package com.visualg.animations.transparentRandomWalk;

import com.badlogic.gdx.scenes.scene2d.Group;

public class TransparentRandomWalkGroup extends Group {
    public TransparentRandomWalkGroup() {
        final TransparentRandomWalkActor transparentRandomWalkActor = new TransparentRandomWalkActor();
        addActor(transparentRandomWalkActor);
        SettingsView settingsView = new SettingsView();
        addActor(settingsView);
    }
}
