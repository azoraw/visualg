package com.visualg.global;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.bezier.Bezier;

import java.util.function.Supplier;

public enum Animation {
    BEZIER(Bezier::new);

    private final Supplier<Actor> animationSupplier;

    Animation(Supplier<Actor> animationSupplier) {
        this.animationSupplier = animationSupplier;
    }

    public Actor getAnimation() {
        return animationSupplier.get();
    }
}
