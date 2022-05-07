package com.visualg.animations.ca;

import com.badlogic.gdx.scenes.scene2d.Group;

public class CellularAutomataGroup extends Group {

    public CellularAutomataGroup() {
        CurrentSettings currentSettings = CurrentSettings.INSTANCE;
        CellularAutomataSettings settingsView = new CellularAutomataSettings(currentSettings);
        CellularAutomataAlg wigglyCircleAlg = new CellularAutomataAlg(currentSettings, settingsView);
        this.addActor(settingsView);
        this.addActor(new CellularAutomataActor(wigglyCircleAlg));
    }
}
