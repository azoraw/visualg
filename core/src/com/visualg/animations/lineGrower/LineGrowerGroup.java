package com.visualg.animations.lineGrower;

import com.badlogic.gdx.scenes.scene2d.Group;

public class LineGrowerGroup extends Group {
    public LineGrowerGroup() {
        LineGrowerAlg alg = new LineGrowerAlg();
        LineGrowerActor pixmapActor = new LineGrowerActor(alg);
        addActor(pixmapActor);
    }
}
