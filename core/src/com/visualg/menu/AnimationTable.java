package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

class AnimationTable extends Table {

    public AnimationTable() {
        this.setFillParent(true);
        this.left().top();
        this.add(new MainMenuButton());
    }
}