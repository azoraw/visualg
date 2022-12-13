package com.visualg.animations.qtree2;

import com.badlogic.gdx.scenes.scene2d.Group;

public class QuadTreeGroup2 extends Group {
    public QuadTreeGroup2() {
        final QuadTreeActor quadTreeActor = new QuadTreeActor();
        addActor(quadTreeActor);
    }
}
