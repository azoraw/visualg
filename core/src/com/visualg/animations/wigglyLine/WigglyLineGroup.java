package com.visualg.animations.wigglyLine;

import com.badlogic.gdx.scenes.scene2d.Group;

public class WigglyLineGroup extends Group/* implements InteractiveActor*/ {

    public WigglyLineGroup() {
        WigglyLineAlg wigglyLineAlg = new WigglyLineAlg();
        Table actor = new Table();
        this.addActor(actor);
        this.addActor(new WigglyLineActor(wigglyLineAlg));
    }
}
