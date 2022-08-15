package com.visualg.animations.labyrinth;

import com.visualg.util.libgdx.ui.SettingsTable;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultButton;

public class LabyrinthGeneratorSettings extends SettingsTable {

    public LabyrinthGeneratorSettings(LabyrinthGeneratorController controller) {
        DefaultButton textButton = new DefaultButton("save", controller::onSave);
        add(textButton);
    }
}
