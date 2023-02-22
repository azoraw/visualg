package com.visualg.controls.events;

import com.badlogic.gdx.scenes.scene2d.Event;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChangeUiScalingEvent extends Event {
    private final float newValue;
}
