package com.visualg.animations.nBody;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.nBody.NBodySettings.settings;

class Table extends SettingsTable {

    Table() {
        addNumericRows(settings);
    }
}
