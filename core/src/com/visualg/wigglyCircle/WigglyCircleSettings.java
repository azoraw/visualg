package com.visualg.wigglyCircle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;

import static com.visualg.global.Config.skin;
import static java.lang.String.valueOf;

class WigglyCircleSettings extends Table {

    private final CurrentSettings currentSettings;
    private final Label zValue;

    public WigglyCircleSettings(CurrentSettings currentSettings) {
        this.currentSettings = currentSettings;
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        top().right();
        Label empty = new Label("", skin);
        this.add(empty);
        row();

        Label settings = new Label("Settings", skin);
        this.add(settings);
        row();

        CheckBox threshold = new CheckBox("threshold", skin);
        threshold.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentSettings.setApplyThreshold(!currentSettings.isApplyThreshold());
                zValue.setText(valueOf(currentSettings.isApplyThreshold()));
            }
        });
        add(threshold);
        row();

        zValue = new Label(valueOf(currentSettings.getZ()), skin);
        add(zValue);
        createTimer();
    }

    private void createTimer() {
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                update();
            }
        }, 0, 0.1f);
    }


    void update() {
        zValue.setText(String.format("%.2f", currentSettings.getZ()));
    }
}
