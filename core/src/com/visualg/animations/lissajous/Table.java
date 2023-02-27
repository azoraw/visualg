package com.visualg.animations.lissajous;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.lissajous.LissajousSettings.settings;

class Table extends SettingsTable {
    public Table() {
        addNumericRows(settings);
    }
}
