package com.visualg.animations.mondrian;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    Table(MondrianActor actor) {
        MondrianSettings mondrianSettings = MondrianSettings.settings;

        addRow(DefaultSettingsRow.builder()
                .label("sideMaxSplitLength")
                .initValue(mondrianSettings.getSideMaxSplitLength())
                .onValueChange(stringValue -> {
                    mondrianSettings.setSideMaxSplitLength(parseInt(stringValue));
                    fire(new RestartEvent());
                })
                .build());
        addRow(DefaultSettingsRow.builder()
                .label("space")
                .initValue(mondrianSettings.getSpace())
                .onValueChange(stringValue -> {
                    mondrianSettings.setSpace(parseInt(stringValue));
                    fire(new RestartEvent());
                })
                .build());

        DefaultCheckBox mondriatCheckBox = DefaultCheckBox.builder()
                .label("Mondriats palette")
                .initValue(mondrianSettings.isMondriatsPalette())
                .onClick(() -> {
                    mondrianSettings.setMondriatsPalette(!mondrianSettings.isMondriatsPalette());
                    fire(new RestartEvent());
                })
                .build();
        add(new EmptyLabel());
        add(mondriatCheckBox);
        row();

        if (!mondrianSettings.isMondriatsPalette()) {
            addRow(DefaultSettingsRow.builder()
                    .label("randomPaletteSize")
                    .initValue(mondrianSettings.getPaletteSize())
                    .onValueChange(stringValue -> {
                        mondrianSettings.setPaletteSize(parseInt(stringValue));
                        fire(new RestartEvent());
                    })
                    .build());

            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient1")
                    .onChange(mondrianSettings::setGradient1)
                    .selected(mondrianSettings.getGradient1())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient2")
                    .onChange(mondrianSettings::setGradient2)
                    .selected(mondrianSettings.getGradient2())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient3")
                    .onChange(mondrianSettings::setGradient3)
                    .selected(mondrianSettings.getGradient3())
                    .items(Gradient.values())
                    .build());
            addRow(SelectBoxRow.<Gradient>builder()
                    .label("gradient4")
                    .onChange(mondrianSettings::setGradient4)
                    .selected(mondrianSettings.getGradient4())
                    .items(Gradient.values())
                    .build());
        }

        add(new EmptyLabel());
        add(new DefaultButton("screenShot", actor.onScreenShot()));
    }
}
