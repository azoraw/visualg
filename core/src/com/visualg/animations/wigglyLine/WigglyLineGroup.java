package com.visualg.animations.wigglyLine;

import com.badlogic.gdx.scenes.scene2d.Group;

public class WigglyLineGroup extends Group/* implements InteractiveActor*/ {

    public WigglyLineGroup() {
        WigglyLineAlg wigglyLineAlg = new WigglyLineAlg();
        Table actor = new Table();
        addActor(actor);
        addActor(new WigglyLineActor(wigglyLineAlg));
    }
}
