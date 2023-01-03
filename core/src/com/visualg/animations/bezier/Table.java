package com.visualg.animations.bezier;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static com.visualg.animations.bezier.Settings.INSTANCE;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table(Runnable screenshot) {

        final Settings settings = INSTANCE;
        final DefaultSettingsRow numberOfBlobs = DefaultSettingsRow.builder()
                .label("number of blobs")
                .initValue(settings.getNumberOfBlobs())
                .onValueChange((str) -> settings.setNumberOfBlobs(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBlobs);
        add(new DefaultLabel("Blobs:"));
        row();
        for (int i = 0; i < settings.getNumberOfBlobs(); i++) {
            int finalI = i;
            add(DefaultCheckBox.builder()
                    .label("gradient")
                    .initValue(false)
                    .onClick(() ->  {
                        settings.getBlobSetting(finalI).setGradient(!settings.getBlobSetting(finalI).isGradient());
                        fire(new RestartEvent());
                    })
                    .build());
            row();
            addRow(DefaultSettingsRow.builder()
                    .label("transparency")
                    .initValue(settings.getBlobSetting(finalI).getTransparency())
                    .onValueChange((str)-> settings.getBlobSetting(finalI).setTransparency(parseFloat(str)))
                    .afterValueChange((s -> fire(new RestartEvent())))
                    .build());
            addRow(SelectBoxRow.<BlobColor>builder()
                    .label("color")
                    .onChange((color) -> settings.getBlobSetting(finalI).setBlobColor(color))
                    .selected(settings.getBlobSetting(finalI).getBlobColor())
                    .items(BlobColor.values())
                    .build());
            if(settings.getBlobSetting(finalI).isGradient()){
                addRow(DefaultSettingsRow.builder()
                        .label("transparency2")
                        .initValue(settings.getBlobSetting(finalI).getTransparency2())
                        .onValueChange((str)-> settings.getBlobSetting(finalI).setTransparency2(parseFloat(str)))
                        .afterValueChange((s -> fire(new RestartEvent())))
                        .build());
                addRow(SelectBoxRow.<BlobColor>builder()
                        .label("color2")
                        .onChange((color) -> settings.getBlobSetting(finalI).setBlobColor2(color))
                        .selected(settings.getBlobSetting(finalI).getBlobColor2())
                        .items(BlobColor.values())
                        .build());
            }
        }
        row();
        add(new EmptyLabel());
        add(new DefaultButton("screenshot", screenshot));
    }
}
