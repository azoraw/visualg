package com.visualg.global;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.bezier.Bezier;
import com.visualg.langtonant.LangtonAnt;
import com.visualg.noise.HairyFlowField;

import java.util.function.Supplier;

public enum Animation {
    LANGTON_ANT(LangtonAnt::new),
    BEZIER(Bezier::new),
    HAIRY_FLOW_FIELD(HairyFlowField::new);

    private final Supplier<Actor> animationSupplier;

    Animation(Supplier<Actor> animationSupplier) {
        this.animationSupplier = animationSupplier;
    }

    public Actor getAnimation() {
        return animationSupplier.get();
    }
}
