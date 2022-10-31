package com.visualg.animations.colorPicker;

import com.visualg.global.Config;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;

class ColorSettings extends SettingsTable {
    public ColorSettings() {
        add(new DefaultButton("setPrimaryColor", () -> Config.updateUserPrimaryColor(Settings.INSTANCE.getChosenColor())));
        row();
        add(new DefaultButton("setSecondaryColor", () -> Config.updateUserSecondaryColor(Settings.INSTANCE.getChosenColor())));
        row();
        add(new DefaultButton("setBackgroundColor", () -> Config.updateUserBackgroundColor(Settings.INSTANCE.getChosenColor())));
    }
}
