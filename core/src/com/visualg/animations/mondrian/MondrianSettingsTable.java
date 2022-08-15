package com.visualg.animations.mondrian;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultButton;
import com.visualg.util.libgdx.ui.DefaultCheckBox;
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

        DefaultCheckBox mondriatCheckBox = DefaultCheckBox.builder()
                .label("Mondriats palette")
                .initValue(settings.isMondriatsPalette())
                .onClick(() -> {
                    settings.setMondriatsPalette(!settings.isMondriatsPalette());
                    fire(new RestartEvent());
                })
                .build();

        add(new EmptyLabel());
        add(mondriatCheckBox);
        row();

        if (!settings.isMondriatsPalette()) {
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
