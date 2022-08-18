package com.visualg.ui.animationToolbar;

import com.visualg.global.Config;
import com.visualg.ui.settings.DefaultSettingsRow;
import lombok.Getter;

class UpdatesPerFrame {

    @Getter
    private final DefaultSettingsRow settingsRow;

    UpdatesPerFrame() {
        settingsRow = DefaultSettingsRow.builder()
                .label("updatesPerFrame")
                .initValue(Config.updatesPerFrame)
                .onValueChange(s -> Config.setUpdatesPerFrame(Integer.parseInt(s)))
                .build();
    }
}
