package com.visualg.animations.bezier;

import com.visualg.controls.events.RestartEvent;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.settings.SelectBoxRow;
import com.visualg.ui.settings.SettingsTable;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultCheckBox;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.ui.simplifiedComponents.EmptyLabel;

import static com.visualg.animations.bezier.BezierSettings.settings;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

class Table extends SettingsTable {
    public Table(Runnable screenshot) {

        final BezierSettings bezierSettings = settings;
        final DefaultSettingsRow numberOfBlobs = DefaultSettingsRow.builder()
                .label("number of blobs")
                .initValue(bezierSettings.getNumberOfBlobs())
                .onValueChange((str) -> bezierSettings.setNumberOfBlobs(parseInt(str)))
                .afterValueChange((str) -> fire(new RestartEvent()))
                .build();
        addRow(numberOfBlobs);
        add(new DefaultLabel("Blobs:"));
        row();
        for (int i = 0; i < bezierSettings.getNumberOfBlobs(); i++) {
            int finalI = i;
            add(DefaultCheckBox.builder()
                    .label("gradient")
                    .initValue(false)
                    .onClick(() ->  {
                        bezierSettings.getBlobSetting(finalI).setGradient(!bezierSettings.getBlobSetting(finalI).isGradient());
                        fire(new RestartEvent());
                    })
                    .build());
            row();
            addRow(DefaultSettingsRow.builder()
                    .label("transparency")
                    .initValue(bezierSettings.getBlobSetting(finalI).getTransparency())
                    .onValueChange((str)-> bezierSettings.getBlobSetting(finalI).setTransparency(parseFloat(str)))
                    .afterValueChange((s -> fire(new RestartEvent())))
                    .build());
            addRow(SelectBoxRow.<BlobColor>builder()
                    .label("color")
                    .onChange((color) -> bezierSettings.getBlobSetting(finalI).setBlobColor(color))
                    .selected(bezierSettings.getBlobSetting(finalI).getBlobColor())
                    .items(BlobColor.values())
                    .build());
            if(bezierSettings.getBlobSetting(finalI).isGradient()){
                addRow(DefaultSettingsRow.builder()
                        .label("transparency2")
                        .initValue(bezierSettings.getBlobSetting(finalI).getTransparency2())
                        .onValueChange((str)-> bezierSettings.getBlobSetting(finalI).setTransparency2(parseFloat(str)))
                        .afterValueChange((s -> fire(new RestartEvent())))
                        .build());
                addRow(SelectBoxRow.<BlobColor>builder()
                        .label("color2")
                        .onChange((color) -> bezierSettings.getBlobSetting(finalI).setBlobColor2(color))
                        .selected(bezierSettings.getBlobSetting(finalI).getBlobColor2())
                        .items(BlobColor.values())
                        .build());
            }
        }
        row();
        add(new EmptyLabel());
        add(new DefaultButton("screenshot", screenshot));
    }
}
