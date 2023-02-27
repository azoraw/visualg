package com.visualg.animations.nBody;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.nBody.NBodySettings.settings;

class TransparentTable extends SettingsTable {

    TransparentTable() {
        addNumericRows(settings);
    }
}
