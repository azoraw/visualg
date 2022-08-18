package com.visualg.animations.ca;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class CurrentSettings {
    static CurrentSettings INSTANCE = new CurrentSettings();

    private int ruleNumber;
    private float animationSpeedInSec = 0.5f;
    float ruleChangeSpeedInSec = 10;

    void incrementRule() {
        ruleNumber++;
        if (ruleNumber > 255) {
            ruleNumber = 0;
        }
    }
}
