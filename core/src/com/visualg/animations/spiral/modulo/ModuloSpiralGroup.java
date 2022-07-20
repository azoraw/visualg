package com.visualg.animations.spiral.modulo;

import com.badlogic.gdx.scenes.scene2d.Group;

public class ModuloSpiralGroup extends Group  {

    public ModuloSpiralGroup() {
        ModuloSpiralActor pixmapActor = new ModuloSpiralActor(new ModuloSpiralAlg());
        addActor(pixmapActor);
    }

}
