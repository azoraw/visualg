package com.visualg.animations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.bezier.Bezier;
import com.visualg.animations.boids.BoidsGroup;
import com.visualg.animations.ca.CellularAutomataGroup;
import com.visualg.animations.circlePacking.CirclePacking;
import com.visualg.animations.doublePendulum.DoublePendulum;
import com.visualg.animations.fractals.juliaset.JuliaSetGroup;
import com.visualg.animations.fractals.mandelbrot.MandelbrotGroup;
import com.visualg.animations.labyrinth.LabyrinthGenerator;
import com.visualg.animations.labyrinth.LabyrinthSolver;
import com.visualg.animations.langtonant.LangtonAnt;
import com.visualg.animations.lines.LinesDoodle;
import com.visualg.animations.mouseFollower.MouseFollowerActor;
import com.visualg.animations.nBody.NBodyGroup;
import com.visualg.animations.noise.flow.FlowFieldActor;
import com.visualg.animations.noise.simplex.ColorNoiseActor;
import com.visualg.animations.noise.simplex.NoiseGroup;
import com.visualg.animations.noise.transparent.HairyFlowFieldGroup;
import com.visualg.animations.rectangles.Rectangles;
import com.visualg.animations.wigglyCircle.WigglyCircleGroup;

import java.util.function.Supplier;

public enum Animation {
    LANGTON_ANT(LangtonAnt::new),
    BEZIER(Bezier::new),
    HAIRY_FLOW_FIELD(HairyFlowFieldGroup::new),
    OPEN_SIMPLEX(NoiseGroup::new),
    FLOW_FIELD(FlowFieldActor::new),
    COLOR_NOISE(ColorNoiseActor::new),
    LINES_DOODLE(LinesDoodle::new),
    RECTANGLES(Rectangles::new),
    CIRCLE_PACKING(CirclePacking::new),
    WIGGLY_CIRCLE(WigglyCircleGroup::new),
    MOUSE_FOLLOWER(MouseFollowerActor::new),
    N_BODY(NBodyGroup::new),
    BOIDS(BoidsGroup::new),
    CELLULAR_AUTOMATA(CellularAutomataGroup::new),
    DOUBLE_PENDULUM(DoublePendulum::new),
    LABYRINTH_GENERATOR(LabyrinthGenerator::new),
    LABYRINTH_SOLVER(LabyrinthSolver::new),
    JULIA_SET(JuliaSetGroup::new),
    MANDELBROT(MandelbrotGroup::new),
    ;

    private final Supplier<Actor> animationSupplier;

    Animation(Supplier<Actor> animationSupplier) {
        this.animationSupplier = animationSupplier;
    }

    public Actor getAnimation() {
        return animationSupplier.get();
    }
}
