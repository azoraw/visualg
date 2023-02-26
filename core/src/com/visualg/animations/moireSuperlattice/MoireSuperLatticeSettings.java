package com.visualg.animations.moireSuperlattice;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class MoireSuperLatticeSettings implements Settings {
    static final MoireSuperLatticeSettings settings = new MoireSuperLatticeSettings();

    private float transparency = 0.5f;
    private int moduloX = 10;
    private int moduloY = 10;
    private float rotationSpeed = 0.1f;
    private ColorOption colorOption = ColorOption.PRIMARY;
    private ColorOption colorOption2 = ColorOption.PRIMARY;
}
