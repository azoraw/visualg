package com.visualg.animations.labyrinth;

import com.visualg.util.libgdx.ui.DefaultButton;
import com.visualg.util.libgdx.ui.SettingsTable;

public class LabyrinthGeneratorSettings extends SettingsTable {

    public LabyrinthGeneratorSettings(LabyrinthGeneratorController controller) {
        DefaultButton textButton = new DefaultButton("save", controller::onSave);
        add(textButton);
    }
}
