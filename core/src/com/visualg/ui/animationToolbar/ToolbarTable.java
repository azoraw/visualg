package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.ui.settings.DefaultSettingsRow;

public class ToolbarTable extends Table {

    public ToolbarTable() {
        setFillParent(true);
        left().top();
        add(new MainMenuButton());
        add(new RestartButton());
        DefaultSettingsRow updatesPerFrame = new UpdatesPerFrame()
                .getSettingsRow();
        add(updatesPerFrame.getLabel());
        add(updatesPerFrame.getWidget());
    }
}
