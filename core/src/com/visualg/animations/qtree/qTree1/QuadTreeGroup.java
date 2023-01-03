package com.visualg.animations.qtree.qTree1;

import com.badlogic.gdx.scenes.scene2d.Group;

public class QuadTreeGroup extends Group {
    public QuadTreeGroup() {
        final QuadTreeActor quadTreeActor = new QuadTreeActor();
        addActor(quadTreeActor);
        addActor(new Table());
    }
}
