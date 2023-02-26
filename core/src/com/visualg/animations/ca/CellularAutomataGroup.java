package com.visualg.animations.ca;

import com.badlogic.gdx.scenes.scene2d.Group;

import static com.visualg.animations.ca.CASettings.settings;

public class CellularAutomataGroup extends Group {

    public CellularAutomataGroup() {
        Table settingsView = new Table(settings);
        CellularAutomataAlg wigglyCircleAlg = new CellularAutomataAlg(settings, settingsView);
        addActor(settingsView);
        addActor(new CellularAutomataActor(wigglyCircleAlg));
    }
}
