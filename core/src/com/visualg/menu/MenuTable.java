package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.animations.Animation;

import static com.visualg.animations.Animation.BEZIER;
import static com.visualg.animations.Animation.BOIDS;
import static com.visualg.animations.Animation.CELLULAR_AUTOMATA;
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
import static com.visualg.animations.Animation.MOUSE_FOLLOWER;
import static com.visualg.animations.Animation.MULTIBROT;
import static com.visualg.animations.Animation.N_BODY;
import static com.visualg.animations.Animation.OPEN_SIMPLEX;
import static com.visualg.animations.Animation.RECTANGLES;
import static com.visualg.animations.Animation.ULAM_SPIRAL;
import static com.visualg.animations.Animation.WIGGLY_CIRCLE;
import static com.visualg.global.Config.skin;

class MenuTable extends Table {

    MenuTable() {
        this.setFillParent(true);
        this.left().top();
        Label titleLabel = new Label("VISUALG", skin);
        this.add(titleLabel);

        this.row();
        Label bezierLabel = new Label("bezier:", skin);
        this.add(bezierLabel);
        createAnimationButton("old windows screen saver", BEZIER);
        createAnimationButton("Rectangles", RECTANGLES);

        this.row();
        Label cellularAutomataLabel = new Label("cellular automata:", skin);
        this.add(cellularAutomataLabel);
        createAnimationButton("2d", CELLULAR_AUTOMATA);
        createAnimationButton("Langton Ant", LANGTON_ANT);

        this.row();
        Label systemsLabel = new Label("systems:", skin);
        this.add(systemsLabel);
        createAnimationButton("n-body", N_BODY);
        createAnimationButton("boids", BOIDS);
        createAnimationButton("double pendulum", DOUBLE_PENDULUM);
        createAnimationButton("mouse follower", MOUSE_FOLLOWER);

        this.row();
        Label openSimplexLabel = new Label("openSimplex:", skin);
        this.add(openSimplexLabel);
        createAnimationButton("HairyFlowField", HAIRY_FLOW_FIELD);
        createAnimationButton("openSimplex", OPEN_SIMPLEX);
        createAnimationButton("flowField", FLOW_FIELD);
        createAnimationButton("ColorNoise", COLOR_NOISE);
        createAnimationButton("WigglyCircle", WIGGLY_CIRCLE);

        this.row();
        Label dfsLabel = new Label("dfs:", skin);
        this.add(dfsLabel);
        createAnimationButton("labyrinth generator", LABYRINTH_GENERATOR);
        createAnimationButton("labyrinth solver", LABYRINTH_SOLVER);

        this.row();
        Label fractalLabel = new Label("fractals:", skin);
        this.add(fractalLabel);
        createAnimationButton("julia set", JULIA_SET);
        createAnimationButton("mandelbrot set", MANDELBROT);
        createAnimationButton("multibrot set", MULTIBROT);


        this.row();
        Label randomLabel = new Label("random:", skin);
        this.add(randomLabel);
        createAnimationButton("LinesDoodle", LINES_DOODLE);
        createAnimationButton("lineGrower", LINES_GROWER);
        createAnimationButton("CirclePacking", CIRCLE_PACKING);
        createAnimationButton("Ulam spiral", ULAM_SPIRAL);
        createAnimationButton("Modulo spiral", MODULO_SPIRAL);

    }

    private void createAnimationButton(String text, Animation animation) {
        Button flowField = new AnimationButton(text, animation);
        this.add(flowField);
    }
}
