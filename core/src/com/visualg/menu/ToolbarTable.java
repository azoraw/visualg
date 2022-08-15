package com.visualg.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.global.Config;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;

class ToolbarTable extends Table {

    ToolbarTable() {
        setFillParent(true);
        left().top();
        add(new MainMenuButton());
        add(new RestartButton());
        DefaultSettingsRow updatesPerFrame = DefaultSettingsRow.builder()
                .label("updatesPerFrame")
                .initValue(Config.updatesPerFrame)
                .onValueChange(s -> Config.setUpdatesPerFrame(Integer.parseInt(s)))
                .build();
        add(updatesPerFrame.getLabel());
        add(updatesPerFrame.getWidget());
    }
}
