package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.global.Animation;
import com.visualg.global.Config;

class TableMenu extends Table {

    public TableMenu() {
        this.setFillParent(true);
        this.center().top();
        Label label = new Label("VISUALG", Config.skin);
        this.add(label);
        this.row();

        Button bezier = new MainMenuButton("Bezier - old windows screen saver", Animation.BEZIER);
        this.add(bezier);

        Button langtonAnt = new MainMenuButton("Langton Ant", Animation.LANGTON_ANT);
        this.add(langtonAnt);

        Button hairyFlowField = new MainMenuButton("HairyFlowField", Animation.HAIRY_FLOW_FIELD);
        this.add(hairyFlowField);

        Button linesDoodle = new MainMenuButton("LinesDoodle", Animation.LINES_DOODLE);
        this.add(linesDoodle);

    }
}
