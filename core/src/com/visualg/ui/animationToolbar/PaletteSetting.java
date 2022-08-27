package com.visualg.ui.animationToolbar;

import com.visualg.global.Config;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsRow;
import com.visualg.util.color.PaletteType;
import lombok.Getter;

public class PaletteSetting {
    @Getter
    private final SettingsRow settingsRow;

    PaletteSetting(Runnable afterChange) {
        settingsRow = SelectBoxRow.<PaletteType>builder()
                .label("palette")
                .onChange(paletteType -> {
                    Config.setPalette(paletteType);
                    afterChange.run();
                })
                .selected(Config.palette)
                .items(PaletteType.values())
                .build();
    }

}
