package com.visualg.ui.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
import static com.visualg.animations.Animation.LABYRINTH_GENERATOR;
import static com.visualg.animations.Animation.LABYRINTH_SOLVER;
import static com.visualg.animations.Animation.LANGTON_ANT;
import static com.visualg.animations.Animation.LINES_DOODLE;
import static com.visualg.animations.Animation.LINES_GROWER;
import static com.visualg.animations.Animation.MANDELBROT;
import static com.visualg.animations.Animation.MODULO_SPIRAL;
import static com.visualg.animations.Animation.MONDRIAN;
import static com.visualg.animations.Animation.MOUSE_FOLLOWER;
import static com.visualg.animations.Animation.MULTIBROT;
import static com.visualg.animations.Animation.N_BODY;
import static com.visualg.animations.Animation.OPEN_SIMPLEX;
import static com.visualg.animations.Animation.RECTANGLES;
import static com.visualg.animations.Animation.TRANSPARENT_BEZIER;
import static com.visualg.animations.Animation.ULAM_SPIRAL;
import static com.visualg.animations.Animation.WAVE_FUNCTION_COLLAPSE;
import static com.visualg.animations.Animation.WIGGLY_CIRCLE;
import static com.visualg.animations.Animation.WIGGLY_LINE;

public class MenuTable extends Table {

    public MenuTable() {
        setFillParent(true);
        left().top();
        Label titleLabel = new DefaultLabel("VISUALG");
        add(titleLabel);

        row();
        Label bezierLabel = new DefaultLabel("bezier:");
        add(bezierLabel);
        createAnimationButton("old windows screen saver", BEZIER);
        createAnimationButton("transparent old screen saver", TRANSPARENT_BEZIER);
        createAnimationButton("Rectangles", RECTANGLES);
        createAnimationButton("Transparent Random Walk", Animation.TRANSPARENT_RANDOM_WALK);

        row();
        Label cellularAutomataLabel = new DefaultLabel("cellular automata:");
        add(cellularAutomataLabel);
        createAnimationButton("2d", CELLULAR_AUTOMATA);
        createAnimationButton("Langton Ant", LANGTON_ANT);
        createAnimationButton("Ulam spiral", ULAM_SPIRAL);
        createAnimationButton("Modulo spiral", MODULO_SPIRAL);


        row();
        Label systemsLabel = new DefaultLabel("systems:");
        add(systemsLabel);
        createAnimationButton("n-body", N_BODY);
        createAnimationButton("boids", BOIDS);
        createAnimationButton("double pendulum", DOUBLE_PENDULUM);
        createAnimationButton("mouse follower", MOUSE_FOLLOWER);

        row();
        Label openSimplexLabel = new DefaultLabel("openSimplex:");
        add(openSimplexLabel);
        createAnimationButton("HairyFlowField", HAIRY_FLOW_FIELD);
        createAnimationButton("openSimplex", OPEN_SIMPLEX);
        createAnimationButton("flowField", FLOW_FIELD);
        createAnimationButton("ColorNoise", COLOR_NOISE);
        createAnimationButton("WigglyCircle", WIGGLY_CIRCLE);
        createAnimationButton("Spaghetti line", WIGGLY_LINE);

        row();
        Label dfsLabel = new DefaultLabel("dfs:");
        add(dfsLabel);
        createAnimationButton("labyrinth generator", LABYRINTH_GENERATOR);
        createAnimationButton("labyrinth solver", LABYRINTH_SOLVER);

        row();
        Label bfsLabel = new DefaultLabel("bfs:");
        add(bfsLabel);
        createAnimationButton("wave function collapse", WAVE_FUNCTION_COLLAPSE);

        row();
        Label fractalLabel = new DefaultLabel("fractals:");
        add(fractalLabel);
        createAnimationButton("julia set", JULIA_SET);
        createAnimationButton("mandelbrot set", MANDELBROT);
        createAnimationButton("multibrot set", MULTIBROT);


        row();
        Label randomLabel = new DefaultLabel("random:");
        add(randomLabel);
        createAnimationButton("LinesDoodle", LINES_DOODLE);
        createAnimationButton("lineGrower", LINES_GROWER);
        createAnimationButton("CirclePacking", CIRCLE_PACKING);
        createAnimationButton("CircleStacking", CIRCLES_STACKING);

        row();
        add(new DefaultLabel("artists:"));
        createAnimationButton("Mondrian", MONDRIAN);
    }

    private void createAnimationButton(String text, Animation animation) {
        Button flowField = new AnimationButton(text, animation);
        add(flowField);
    }
}
