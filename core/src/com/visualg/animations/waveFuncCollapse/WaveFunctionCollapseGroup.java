package com.visualg.animations.waveFuncCollapse;

import com.badlogic.gdx.scenes.scene2d.Group;

public class WaveFunctionCollapseGroup extends Group {
    public WaveFunctionCollapseGroup() {
        WFCActor wfcActor = new WFCActor();
        WFCSettingsTable WFCSettingsTable = new WFCSettingsTable(wfcActor);
        addActor(WFCSettingsTable);
        addActor(wfcActor);
    }
}
