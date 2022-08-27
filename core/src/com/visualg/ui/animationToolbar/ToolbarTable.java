package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.visualg.controls.events.RestartEvent;
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
        PaletteSetting paletteSetting = new PaletteSetting(() -> fire(new RestartEvent()));
        add(paletteSetting.getSettingsRow().getLabel());
        add(paletteSetting.getSettingsRow().getWidget());

    }
}
