package com.visualg.animations.wigglyLine;

import com.badlogic.gdx.scenes.scene2d.Group;

public class WigglyLineGroup extends Group/* implements InteractiveActor*/ {

    public WigglyLineGroup() {
        Settings settings = new Settings();
        WigglyLineAlg wigglyLineAlg = new WigglyLineAlg();
        WigglyLineSettingsTable actor = new WigglyLineSettingsTable(settings);
        this.addActor(actor);
        this.addActor(new WigglyLineActor(wigglyLineAlg));
    }
}
