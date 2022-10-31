package com.visualg.animations.waveFuncCollapse;

import lombok.Data;

@Data
public class Settings {
    public static Settings INSTANCE = new Settings();
    public Variant variant = Variant.TILES1;
}
