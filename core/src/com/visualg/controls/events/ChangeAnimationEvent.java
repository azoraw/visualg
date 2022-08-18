package com.visualg.controls.events;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.visualg.animations.Animation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ChangeAnimationEvent extends Event {
    private final Animation animation;
}
