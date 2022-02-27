package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ExitTable extends Table {

    public ExitTable() {
        this.setFillParent(true);
        this.right().top();
        this.add(new ExitButton());
    }
}
