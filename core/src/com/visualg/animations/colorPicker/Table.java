package com.visualg.animations.colorPicker;

import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.util.color.PaletteType;

class Table extends SettingsTable {
    public Table() {
        add(new DefaultButton("setPrimaryColor", () -> PaletteType.updateUserPrimaryColor(Settings.INSTANCE.getChosenColor())));
        row();
        add(new DefaultButton("setSecondaryColor", () -> PaletteType.updateUserSecondaryColor(Settings.INSTANCE.getChosenColor())));
        row();
        add(new DefaultButton("setBackgroundColor", () -> PaletteType.updateUserBackgroundColor(Settings.INSTANCE.getChosenColor())));
    }
}
