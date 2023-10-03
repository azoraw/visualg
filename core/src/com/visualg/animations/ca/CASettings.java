package com.visualg.animations.ca;

import com.visualg.ui.settings.Settings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
class CASettings implements Settings {
    static final CASettings settings = new CASettings();
    private final int[] interestingRules = {18, 25, 30, 45, 73, 75, 82, 86, 89, 105, 124, 126, 129, 135, 137, 149, 150, 161, 165, 169, 193, 225};
    float ruleChangeSpeedInSec = 60;
    private int ruleNumber;
    private float animationSpeedInSec = 0.5f;
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
