package com.visualg.animations.labyrinth;

import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

class LabyrinthGeneratorSettings extends SettingsTable {

    LabyrinthGeneratorSettings(LabyrinthGeneratorController controller) {
        DefaultButton textButton = new DefaultButton("save", controller::onSave);
        add(textButton);
    }
}
