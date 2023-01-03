package com.visualg.animations.waveFuncCollapse;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Settings {
    public static Settings INSTANCE = new Settings();
    public Variant variant = Variant.TILES1;
}
