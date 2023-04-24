package com.visualg.animations.template;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class TempleSettings implements Settings {
    static final TempleSettings settings = new TempleSettings();

}
