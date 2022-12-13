package com.visualg.animations.qTree;

import com.badlogic.gdx.scenes.scene2d.Group;

public class QuadTreeGroup extends Group {
    public QuadTreeGroup() {
        final QuadTreeActor quadTreeActor = new QuadTreeActor();
        addActor(quadTreeActor);
    }
}
