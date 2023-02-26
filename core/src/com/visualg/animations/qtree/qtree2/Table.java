package com.visualg.animations.qtree.qtree2;

import com.visualg.ui.settings.SettingsTable;

import static com.visualg.animations.qtree.qtree2.QTree2Settings.settings;

class Table extends SettingsTable {
    Table() {
        addNumericRows(settings);
    }
}
