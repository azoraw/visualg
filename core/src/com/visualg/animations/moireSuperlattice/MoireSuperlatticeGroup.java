package com.visualg.animations.moireSuperlattice;

import com.badlogic.gdx.scenes.scene2d.Group;

public class MoireSuperlatticeGroup extends Group {
    public MoireSuperlatticeGroup() {
        addActor(new MoireSuperlatticeActor());
        addActor(new Table());
    }
}
