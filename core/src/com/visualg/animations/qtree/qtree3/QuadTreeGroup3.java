package com.visualg.animations.qtree.qtree3;

import com.badlogic.gdx.scenes.scene2d.Group;

public class QuadTreeGroup3 extends Group {
    public QuadTreeGroup3() {
        final QuadTreeActor quadTreeActor = new QuadTreeActor();
        addActor(quadTreeActor);
        addActor(new Table());
    }
}
