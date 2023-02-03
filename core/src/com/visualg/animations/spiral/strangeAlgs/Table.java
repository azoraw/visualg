package com.visualg.animations.spiral.strangeAlgs;

import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

public class Table extends SettingsTable {

    public Table(Runnable screenshot) {
        add(new DefaultButton("screenshot", screenshot));
    }
}
