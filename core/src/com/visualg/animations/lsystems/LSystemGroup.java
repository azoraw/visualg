package com.visualg.animations.lsystems;

import com.badlogic.gdx.scenes.scene2d.Group;

public class LSystemGroup extends Group {
    public LSystemGroup() {
        final LSystemActor actor = new LSystemActor();
        addActor(actor);
        addActor(new Table(actor.onScreenShot()));
    }
}
