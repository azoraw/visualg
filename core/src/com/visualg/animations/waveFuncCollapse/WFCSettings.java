package com.visualg.animations.waveFuncCollapse;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class WFCSettings implements Settings {
    public static final WFCSettings settings = new WFCSettings();
    public Variant variant = Variant.TILES1;
}
