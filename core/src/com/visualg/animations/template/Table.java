package com.visualg.animations.template;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.template.TempleSettings.settings;

class Table extends SettingsTable {

    Table() {
        addNumericRows(settings);
    }
}
