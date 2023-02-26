package com.visualg.animations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.visualg.animations.bezier.BezierActor;
import com.visualg.animations.bezier.TransparentBezierGroup;
import com.visualg.animations.boids.BoidsGroup;
import com.visualg.animations.ca.CellularAutomataGroup;
import com.visualg.animations.circlePacking.CirclePackingActor;
import com.visualg.animations.circleStacking.CircleStackingGroup;
import com.visualg.animations.colorPicker.ColorPickerGroup;
import com.visualg.animations.doublePendulum.DoublePendulumActor;
import com.visualg.animations.fractals.juliaset.JuliaSetGroup;
import com.visualg.animations.fractals.mandelbrot.MandelbrotGroup;
import com.visualg.animations.fractals.multibrot.MultibrotSetGroup;
import com.visualg.animations.kandynsky.KandynskyGroup;
import com.visualg.animations.labyrinth.LabyrinthGeneratorGroup;
import com.visualg.animations.labyrinth.LabyrinthSolverActor;
import com.visualg.animations.langtonant.LangtonAntActor;
import com.visualg.animations.lineGrower.LineGrowerGroup;
import com.visualg.animations.lines.LinesDoodleActor;
import com.visualg.animations.lissajous.LissajousCurveGroup;
import com.visualg.animations.lsystems.LSystemGroup;
import com.visualg.animations.moireSuperlattice.MoireSuperlatticeGroup;
import com.visualg.animations.mondrian.MondrianGroup;
import com.visualg.animations.mouseFollower.MouseFollowerActor;
import com.visualg.animations.nBody.NBodyGroup;
import com.visualg.animations.nBody.TransparentNBodyGroup;
import com.visualg.animations.noise.flow.FlowFieldActor;
import com.visualg.animations.noise.simplex.ColorNoiseActor;
import com.visualg.animations.noise.simplex.NoiseGroup;
import com.visualg.animations.noise.transparent.HairyFlowFieldGroup;
import com.visualg.animations.qtree.qTree1.QuadTreeGroup;
import com.visualg.animations.rectangles.RectanglesActor;
import com.visualg.animations.rectangles.RectanglesTransparentActor;
import com.visualg.animations.spiral.modulo.ModuloSpiralGroup;
import com.visualg.animations.spiral.ulam.UlamSpiralGroup;
import com.visualg.animations.transparentRandomWalk.TransparentRandomWalkGroup;
import com.visualg.animations.waveFuncCollapse.WaveFunctionCollapseGroup;
import com.visualg.animations.wigglyCircle.WigglyCircleGroup;
import com.visualg.animations.wigglyLine.WigglyLineGroup;
import lombok.Getter;

import java.util.function.Supplier;

public enum Animation {
    BEZIER(BezierActor::new),
    BOIDS(BoidsGroup::new),
    CELLULAR_AUTOMATA(CellularAutomataGroup::new),
    CIRCLES_STACKING(CircleStackingGroup::new),
    CIRCLE_PACKING(CirclePackingActor::new),
    COLOR_NOISE(ColorNoiseActor::new),
    COLOR_PICKER(ColorPickerGroup::new),
    DOUBLE_PENDULUM(DoublePendulumActor::new),
    FLOW_FIELD(FlowFieldActor::new),
    HAIRY_FLOW_FIELD(HairyFlowFieldGroup::new),
    JULIA_SET(JuliaSetGroup::new),
    KANDYNSKY(KandynskyGroup::new),
    LABYRINTH_GENERATOR(LabyrinthGeneratorGroup::new),
    LABYRINTH_SOLVER(LabyrinthSolverActor::new),
    LANGTON_ANT(LangtonAntActor::new),
    LINES_DOODLE(LinesDoodleActor::new),
    LINES_GROWER(LineGrowerGroup::new),
    LISSAJOUS_CURVE(LissajousCurveGroup::new),
    L_SYSTEM(LSystemGroup::new),
    MANDELBROT(MandelbrotGroup::new),
    MODULO_SPIRAL(ModuloSpiralGroup::new),
    MOIRE_SUPERLATTICE(MoireSuperlatticeGroup::new),
    MONDRIAN(MondrianGroup::new),
    MOUSE_FOLLOWER(MouseFollowerActor::new),
    MULTIBROT(MultibrotSetGroup::new),
    N_BODY(NBodyGroup::new),
    N_BODY_TRANSPARENT(TransparentNBodyGroup::new),
    OPEN_SIMPLEX(NoiseGroup::new),
    QUAD_TREE(QuadTreeGroup::new),
    QUAD_TREE2(com.visualg.animations.qtree.qtree2.QuadTreeGroup2::new),
    QUAD_TREE3(com.visualg.animations.qtree.qtree3.QuadTreeGroup3::new),
    RECTANGLES(RectanglesActor::new),
    RECTANGLES2(RectanglesTransparentActor::new),
    TRANSPARENT_BEZIER(TransparentBezierGroup::new, true),
    TRANSPARENT_RANDOM_WALK(TransparentRandomWalkGroup::new),
    ULAM_SPIRAL(UlamSpiralGroup::new),
    WAVE_FUNCTION_COLLAPSE(WaveFunctionCollapseGroup::new),
    WIGGLY_CIRCLE(WigglyCircleGroup::new),
    WIGGLY_LINE(WigglyLineGroup::new);

    private final Supplier<Actor> animationSupplier;
    @Getter
    private boolean recordable = false;

    Animation(Supplier<Actor> animationSupplier) {
        this.animationSupplier = animationSupplier;
    }

    Animation(Supplier<Actor> animationSupplier, boolean recordable) {
        this.animationSupplier = animationSupplier;
        this.recordable = recordable;
    }

    public Actor getAnimation() {
        return animationSupplier.get();
    }
}
