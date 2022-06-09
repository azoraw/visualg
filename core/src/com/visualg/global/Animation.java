package com.visualg.global;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.bezier.Bezier;
import com.visualg.animations.ca.CellularAutomataGroup;
import com.visualg.animations.circlePacking.CirclePacking;
import com.visualg.animations.langtonant.LangtonAnt;
import com.visualg.animations.lines.LinesDoodle;
import com.visualg.animations.nBody.NBodyGroup;
import com.visualg.animations.noise.FlowField;
import com.visualg.animations.noise.HairyFlowField;
import com.visualg.animations.noise.HairyFlowFieldLines;
import com.visualg.animations.noise.Noise;
import com.visualg.animations.rectangles.Rectangles;
import com.visualg.animations.wigglyCircle.WigglyCircleGroup;

import java.util.function.Supplier;

public enum Animation {
    LANGTON_ANT(LangtonAnt::new),
    BEZIER(Bezier::new),
    HAIRY_FLOW_FIELD(HairyFlowField::new),
    HAIRY_FLOW_FIELD_LINES(HairyFlowFieldLines::new),
    LINES_DOODLE(LinesDoodle::new),
    RECTANGLES(Rectangles::new),
    CIRCLE_PACKING(CirclePacking::new),
    WIGGLY_CIRCLE(WigglyCircleGroup::new),
    N_BODY(NBodyGroup::new),
    OPEN_SIMPLEX(Noise::new),
    FLOW_FIELD(FlowField::new),
    CELLULAR_AUTOMATA(CellularAutomataGroup::new);

    private final Supplier<Actor> animationSupplier;

    Animation(Supplier<Actor> animationSupplier) {
        this.animationSupplier = animationSupplier;
    }

    public Actor getAnimation() {
        return animationSupplier.get();
    }
}
