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

    }
}
