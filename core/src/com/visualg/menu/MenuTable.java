package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.global.Animation;
import com.visualg.global.Config;

import static com.visualg.global.Animation.BEZIER;
import static com.visualg.global.Animation.CIRCLE_PACKING;
import static com.visualg.global.Animation.FLOW_FIELD;
import static com.visualg.global.Animation.HAIRY_FLOW_FIELD;
import static com.visualg.global.Animation.HAIRY_FLOW_FIELD_LINES;
import static com.visualg.global.Animation.LANGTON_ANT;
import static com.visualg.global.Animation.LINES_DOODLE;
import static com.visualg.global.Animation.N_BODY;
import static com.visualg.global.Animation.OPEN_SIMPLEX_DOTS;
import static com.visualg.global.Animation.RECTANGLES;
import static com.visualg.global.Animation.WIGGLY_CIRCLE;

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
        createAnimationButton("HairyFlowFieldLines", HAIRY_FLOW_FIELD_LINES);
        createAnimationButton("openSimplexDots", OPEN_SIMPLEX_DOTS);
        createAnimationButton("flowField", FLOW_FIELD);
    }

    private void createAnimationButton(String text, Animation animation) {
        Button flowField = new AnimationButton(text, animation);
        this.add(flowField);
    }
}
