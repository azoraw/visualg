package com.visualg.animations.qtree.qTree1;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.qtree.qTree1.QTree1Settings.settings;

class Table extends SettingsTable {
    Table() {
        addNumericRows(settings);
    }
}
