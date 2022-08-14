package com.visualg.animations.mondrian;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.visualg.global.Config;
import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultButton;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.EmptyLabel;
import com.visualg.util.libgdx.ui.SettingsTable;

import static java.lang.Integer.parseInt;

class MondrianSettingsTable extends SettingsTable {
    public MondrianSettingsTable(MondrianActor actor) {
        Settings settings = Settings.INSTANCE;

        addRow(DefaultSettingsRow.builder()
                .label("sideMaxSplitLength")
                .initValue(settings.getSideMaxSplitLength())
                .onValueChange(stringValue -> settings.setSideMaxSplitLength(parseInt(stringValue)))
                .afterValueChange(s -> this.fire(new RestartEvent()))
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("space")
                .initValue(settings.getSpace())
                .onValueChange(stringValue -> settings.setSpace(parseInt(stringValue)))
                .afterValueChange(s -> this.fire(new RestartEvent()))
                .build());

        CheckBox mondriat = new CheckBox("Mondriats palette", Config.skin);
        mondriat.setChecked(settings.isMondriatsPalette());
        mondriat.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                settings.setMondriatsPalette(!settings.isMondriatsPalette());
                fire(new RestartEvent());
            }
        });
        add(new EmptyLabel());
        add(mondriat);
        row();

        if(!settings.isMondriatsPalette()) {
            addRow(DefaultSettingsRow.builder()
                    .label("randomPaletteSize")
                    .initValue(settings.getPaletteSize())
                    .onValueChange(stringValue -> settings.setPaletteSize(parseInt(stringValue)))
                    .afterValueChange(s -> this.fire(new RestartEvent()))
                    .build());
        }
        add(new EmptyLabel());
        add(new DefaultButton("screenShot", actor.onScreenShot()));
    }
}
