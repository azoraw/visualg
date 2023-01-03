package com.visualg.animations.ca;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class Settings {
    static Settings INSTANCE = new Settings();
    private final int[] interestingRules = {18, 25, 30, 45, 73, 75, 82, 86, 89, 105, 124, 126, 129, 135, 137, 149, 150, 161, 165, 169, 193, 225};

    private int ruleNumber;
    private float animationSpeedInSec = 0.5f;
    float ruleChangeSpeedInSec = 60;
    private boolean onlyInteresting = false;
    private int onlyInterestingIndex = 0;

    void incrementRule() {
        if (onlyInteresting) {
            if (onlyInterestingIndex > interestingRules.length) {
                onlyInterestingIndex = 0;
            }
            ruleNumber = interestingRules[onlyInterestingIndex++];
        } else {
            ruleNumber++;
            if (ruleNumber > 255) {
                ruleNumber = 0;
            }
        }
    }

    public void onInterestingChange() {
        onlyInteresting = !onlyInteresting;
        onlyInterestingIndex = 0;
    }
}
