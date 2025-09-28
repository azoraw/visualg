package com.visualg.animations.colorPicker;

import com.badlogic.gdx.graphics.Color;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.EmptyLabel;
import com.visualg.util.color.PaletteType;

class Table extends SettingsTable {
    public Table() {
        add(new EmptyLabel());
        row();
        add(new DefaultButton("setPrimaryColor", () -> PaletteType.updateUserPrimaryColor(ColorPickerSettings.settings.getChosenColor())));
        row();
        add(new DefaultButton("setSecondaryColor", () -> PaletteType.updateUserSecondaryColor(ColorPickerSettings.settings.getChosenColor())));
        row();
        add(new DefaultButton("setBackgroundColor", () -> PaletteType.updateUserBackgroundColor(ColorPickerSettings.settings.getChosenColor())));
        row();
        add(new DefaultButton("light mode", () -> {
            PaletteType.updateUserBackgroundColor(Color.WHITE);
            PaletteType.updateUserPrimaryColor(Color.BLACK);
        }));
        row();
        add(new DefaultButton("dark mode", () -> {
            PaletteType.updateUserBackgroundColor(Color.BLACK);
            PaletteType.updateUserPrimaryColor(Color.WHITE);
        }));
    }
}
