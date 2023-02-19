package com.visualg.ui.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.animations.Animation;
import com.visualg.ui.simplifiedComponents.DefaultLabel;

import static com.visualg.animations.Animation.BEZIER;
import static com.visualg.animations.Animation.BOIDS;
import static com.visualg.animations.Animation.CELLULAR_AUTOMATA;
import static com.visualg.animations.Animation.CIRCLES_STACKING;
import static com.visualg.animations.Animation.CIRCLE_PACKING;
import static com.visualg.animations.Animation.COLOR_NOISE;
import static com.visualg.animations.Animation.DOUBLE_PENDULUM;
import static com.visualg.animations.Animation.FLOW_FIELD;
import static com.visualg.animations.Animation.HAIRY_FLOW_FIELD;
import static com.visualg.animations.Animation.JULIA_SET;
import static com.visualg.animations.Animation.KANDYNSKY;
import static com.visualg.animations.Animation.LABYRINTH_GENERATOR;
import static com.visualg.animations.Animation.LABYRINTH_SOLVER;
import static com.visualg.animations.Animation.LANGTON_ANT;
import static com.visualg.animations.Animation.LINES_DOODLE;
import static com.visualg.animations.Animation.LINES_GROWER;
import static com.visualg.animations.Animation.LISSAJOUS_CURVE;
import static com.visualg.animations.Animation.MANDELBROT;
import static com.visualg.animations.Animation.MODULO_SPIRAL;
import static com.visualg.animations.Animation.MOIRE_SUPERLATTICE;
import static com.visualg.animations.Animation.MONDRIAN;
import static com.visualg.animations.Animation.MOUSE_FOLLOWER;
import static com.visualg.animations.Animation.MULTIBROT;
import static com.visualg.animations.Animation.N_BODY;
import static com.visualg.animations.Animation.N_BODY_TRANSPARENT;
import static com.visualg.animations.Animation.OPEN_SIMPLEX;
import static com.visualg.animations.Animation.QUAD_TREE;
import static com.visualg.animations.Animation.QUAD_TREE2;
import static com.visualg.animations.Animation.QUAD_TREE3;
import static com.visualg.animations.Animation.QUAD_TREE4;
import static com.visualg.animations.Animation.RECTANGLES;
import static com.visualg.animations.Animation.RECTANGLES2;
import static com.visualg.animations.Animation.TRANSPARENT_BEZIER;
import static com.visualg.animations.Animation.ULAM_SPIRAL;
import static com.visualg.animations.Animation.WAVE_FUNCTION_COLLAPSE;
import static com.visualg.animations.Animation.WIGGLY_CIRCLE;
import static com.visualg.animations.Animation.WIGGLY_LINE;

public class MenuTable extends Table {

    public MenuTable() {
        setFillParent(true);
        left().top();
        addLabel("VISUALG");

        row();
        addLabel("bezier");
        createAnimationButton("OldWindowsScreenSaver", BEZIER);
        createAnimationButton("TransparentOldScreenSaver", TRANSPARENT_BEZIER);
        createAnimationButton("Rectangles", RECTANGLES);
        createAnimationButton("RectanglesTransparent", RECTANGLES2);

        row();
        addLabel("cellular automata");
        createAnimationButton("2d", CELLULAR_AUTOMATA);
        createAnimationButton("LangtonAnt", LANGTON_ANT);
        createAnimationButton("UlamSpiral", ULAM_SPIRAL);
        createAnimationButton("ModuloSpiral", MODULO_SPIRAL);

        row();
        addLabel("systems");
        createAnimationButton("n-body", N_BODY);
        createAnimationButton("n-bodyTransparent", N_BODY_TRANSPARENT);
        createAnimationButton("Boids", BOIDS);
        createAnimationButton("DoublePendulum", DOUBLE_PENDULUM);
        createAnimationButton("MouseFollower", MOUSE_FOLLOWER);

        row();
        addLabel("openSimplex");
        createAnimationButton("HairyFlowField", HAIRY_FLOW_FIELD);
        createAnimationButton("OpenSimplex", OPEN_SIMPLEX);
        createAnimationButton("FlowField", FLOW_FIELD);
        createAnimationButton("ColorNoise", COLOR_NOISE);
        createAnimationButton("WigglyCircle", WIGGLY_CIRCLE);
        createAnimationButton("SpaghettiLine", WIGGLY_LINE);

        row();
        addLabel("dfs");
        createAnimationButton("LabyrinthGenerator", LABYRINTH_GENERATOR);
        createAnimationButton("LabyrinthSolver", LABYRINTH_SOLVER);

        row();
        addLabel("bfs");
        createAnimationButton("WaveFunctionCollapse", WAVE_FUNCTION_COLLAPSE);

        row();
        addLabel("fractals");
        createAnimationButton("JuliaSet", JULIA_SET);
        createAnimationButton("MandelbrotSet", MANDELBROT);
        createAnimationButton("MultibrotSet", MULTIBROT);


        row();
        addLabel("random");
        createAnimationButton("LinesDoodle", LINES_DOODLE);
        createAnimationButton("LineGrower", LINES_GROWER);
        createAnimationButton("CirclePacking", CIRCLE_PACKING);
        createAnimationButton("CircleStacking", CIRCLES_STACKING);
        createAnimationButton("TransparentRandomWalk", Animation.TRANSPARENT_RANDOM_WALK);
        createAnimationButton("MoireSuperlattice", MOIRE_SUPERLATTICE);
        createAnimationButton("LissajousCurve", LISSAJOUS_CURVE);

        row();
        addLabel("artists");
        createAnimationButton("Mondrian", MONDRIAN);
        createAnimationButton("Kandynsky", KANDYNSKY);

        row();
        addLabel("quadtree");
        createAnimationButton("qTree", QUAD_TREE);
        createAnimationButton("qTree2", QUAD_TREE2);
        createAnimationButton("qTree3", QUAD_TREE3);
        createAnimationButton("qTree4", QUAD_TREE4);
    }

    private void createAnimationButton(String text, Animation animation) {
        AnimationButton button = new AnimationButton(text, animation);
        add(button).fill();
    }

    private void addLabel(String labelText) {
        final DefaultLabel label = new DefaultLabel(labelText);
        add(label);
    }
}
