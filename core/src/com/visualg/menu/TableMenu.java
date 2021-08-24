package com.visualg.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class TableMenu extends Table {

    private final MainMenu mainStage;

    public TableMenu(MainMenu mainStage) {
        this.mainStage = mainStage;

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        this.setFillParent(true);
        this.center().top();

        Label label = new Label("VISUALG", skin);
        this.add(label);
        this.row();

        Button button = new TextButton("Bezier - old windows screen saver", skin);
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainStage.showAnimation(Animation.BEZIER);
            }
        });
        this.add(button);
    }
}
