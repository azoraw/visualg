package com.visualg.animations.labyrinth;

import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

class Table extends SettingsTable {

    Table(LabyrinthGeneratorController controller) {
        DefaultButton textButton = new DefaultButton("save", controller::onSave);
        add(textButton);
    }
}
