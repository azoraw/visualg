package com.visualg.animations.qtree.qtree3;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.qtree.qtree3.Qtree3Settings.settings;

class Table extends SettingsTable {
    Table() {
        addNumericRows(settings);
    }
}
