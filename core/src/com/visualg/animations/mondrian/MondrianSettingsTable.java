package com.visualg.animations.mondrian;

import com.visualg.menu.RestartEvent;
import com.visualg.util.libgdx.ui.DefaultSettingsRow;
import com.visualg.util.libgdx.ui.SelectBoxRow;
import com.visualg.util.libgdx.ui.SettingsTable;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultButton;
import com.visualg.util.libgdx.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.util.libgdx.ui.simplifiedComponents.EmptyLabel;

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

            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient1")
                    .onChange(settings::setGradient1)
                    .selected(settings.getGradient1())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient2")
                    .onChange(settings::setGradient2)
                    .selected(settings.getGradient2())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient3")
                    .onChange(settings::setGradient3)
                    .selected(settings.getGradient3())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient4")
                    .onChange(settings::setGradient4)
                    .selected(settings.getGradient4())
                    .items(Gradient.values())
                    .build());
        }

        add(new EmptyLabel());
        add(new DefaultButton("screenShot", actor.onScreenShot()));
    }
}
