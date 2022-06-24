package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.animations.Animation;
import com.visualg.global.Config;

import static com.visualg.animations.Animation.BEZIER;
import static com.visualg.animations.Animation.CELLULAR_AUTOMATA;
import static com.visualg.animations.Animation.CIRCLE_PACKING;
import static com.visualg.animations.Animation.COLOR_NOISE;
import static com.visualg.animations.Animation.DOUBLE_PENDULUM;
import static com.visualg.animations.Animation.FLOW_FIELD;
import static com.visualg.animations.Animation.HAIRY_FLOW_FIELD;
import static com.visualg.animations.Animation.LANGTON_ANT;
import static com.visualg.animations.Animation.LINES_DOODLE;
import static com.visualg.animations.Animation.N_BODY;
import static com.visualg.animations.Animation.OPEN_SIMPLEX;
import static com.visualg.animations.Animation.RECTANGLES;
import static com.visualg.animations.Animation.WIGGLY_CIRCLE;

class MenuTable extends Table {

    MenuTable() {
        this.setFillParent(true);
        this.left().top();
        Label label = new Label("VISUALG", Config.skin);
        this.add(label);

        this.row();
        createAnimationButton("Bezier - old windows screen saver", BEZIER);
        createAnimationButton("Langton Ant", LANGTON_ANT);
        createAnimationButton("LinesDoodle", LINES_DOODLE);
        createAnimationButton("Rectangles", RECTANGLES);
        createAnimationButton("CirclePacking", CIRCLE_PACKING);
        this.row();
        createAnimationButton("WigglyCircle", WIGGLY_CIRCLE);
        createAnimationButton("n-body", N_BODY);
        this.row();
        createAnimationButton("HairyFlowField", HAIRY_FLOW_FIELD);
        createAnimationButton("openSimplex", OPEN_SIMPLEX);
        createAnimationButton("flowField", FLOW_FIELD);
        createAnimationButton("ColorNoise", COLOR_NOISE);

        this.row();
        createAnimationButton("cellular automata", CELLULAR_AUTOMATA);
        createAnimationButton("double pendulum", DOUBLE_PENDULUM);
    }

    private void createAnimationButton(String text, Animation animation) {
        Button flowField = new AnimationButton(text, animation);
        this.add(flowField);
    }
}
