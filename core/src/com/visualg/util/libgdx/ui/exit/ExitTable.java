package com.visualg.util.libgdx.ui.exit;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ExitTable extends Table {

    public ExitTable() {
        this.setFillParent(true);
        this.right().top();
        this.add(new ExitButton());
    }
}
