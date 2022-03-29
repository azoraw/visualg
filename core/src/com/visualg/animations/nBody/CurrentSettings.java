package com.visualg.animations.nBody;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class CurrentSettings {
    static CurrentSettings INSTANCE = new CurrentSettings();

    private float g = 5f;
    private int numberOfBodies = 3;

}
