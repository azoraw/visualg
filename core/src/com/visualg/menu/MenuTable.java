package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.global.Animation;
import com.visualg.global.Config;

class MenuTable extends Table {

    public MenuTable() {
        this.setFillParent(true);
        this.left().top();
        Label label = new Label("VISUALG", Config.skin);
        this.add(label);
        this.row();

        Button bezier = new AnimationButton("Bezier - old windows screen saver", Animation.BEZIER);
        this.add(bezier);

        Button langtonAnt = new AnimationButton("Langton Ant", Animation.LANGTON_ANT);
        this.add(langtonAnt);

        Button linesDoodle = new AnimationButton("LinesDoodle", Animation.LINES_DOODLE);
        this.add(linesDoodle);

        Button rectangles = new AnimationButton("Rectangles", Animation.RECTANGLES);
        this.add(rectangles);

        Button circlePacking = new AnimationButton("CirclePacking", Animation.CIRCLE_PACKING);
        this.add(circlePacking);

        this.row();

        Button wigglyCircle = new AnimationButton("WigglyCircle", Animation.WIGGLY_CIRCLE);
        this.add(wigglyCircle);

        this.row();

        Button hairyFlowField = new AnimationButton("HairyFlowField", Animation.HAIRY_FLOW_FIELD);
        this.add(hairyFlowField);

        Button hairyFlowFieldLines = new AnimationButton("HairyFlowFieldLines", Animation.HAIRY_FLOW_FIELD_LINES);
        this.add(hairyFlowFieldLines);

    }
}
