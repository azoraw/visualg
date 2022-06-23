package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.visualg.animations.Animation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
class ChangeAnimationEvent extends Event {
    private final Animation animation;
}
