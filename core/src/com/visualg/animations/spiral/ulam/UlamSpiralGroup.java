package com.visualg.animations.spiral.ulam;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.visualg.util.libgdx.PixmapActor;

public class UlamSpiralGroup extends Group  {

    public UlamSpiralGroup() {
        PixmapActor pixmapActor = new PixmapActor(new UlamSpiralAlg());
        addActor(pixmapActor);
    }

}
