package com.visualg.animations.waveFuncCollapse;

import com.badlogic.gdx.scenes.scene2d.Group;

public class WaveFunctionCollapseGroup extends Group {
    public WaveFunctionCollapseGroup() {
        WFCActor wfcActor = new WFCActor();
        Table Table = new Table(wfcActor);
        addActor(Table);
        addActor(wfcActor);
    }
}
