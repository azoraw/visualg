package com.visualg.animations.qtree.qtree4;

import com.badlogic.gdx.scenes.scene2d.Group;

public class QuadTreeGroup4 extends Group {
    public QuadTreeGroup4() {
        final QuadTreeActor quadTreeActor = new QuadTreeActor();
        addActor(quadTreeActor);
        addActor(new Table());
    }
}
