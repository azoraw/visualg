package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

class ToolbarTable extends Table {

    ToolbarTable() {
        setFillParent(true);
        left().top();
        add(new MainMenuButton());
        add(new RestartButton());
    }
}
