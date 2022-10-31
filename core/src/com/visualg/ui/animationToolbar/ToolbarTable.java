package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.visualg.animations.Animation;
import com.visualg.controls.events.ChangeAnimationEvent;
import com.visualg.controls.events.RestartEvent;
import com.visualg.global.Config;
import com.visualg.ui.settings.DefaultSettingsRow;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultLabel;

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
        if (Config.getCurrentAnimation().isRecordable()) {
            RecordingToolbar recordingToolbar = new RecordingToolbar();
            add(recordingToolbar.getLabel());
            add(recordingToolbar.getFrameCount());
            add(recordingToolbar.getStart());
            add(recordingToolbar.getStop());
            add(recordingToolbar.getSchedule());
        }
        PaletteSetting paletteSetting = new PaletteSetting(() -> fire(new RestartEvent()));
        add(paletteSetting.getSettingsRow().getLabel());
        add(paletteSetting.getSettingsRow().getWidget());

        addPrimaryColor();
        addSecondaryColor();
        addBackgroundColor();
        add(new DefaultButton("colorPicker", () -> fire(new ChangeAnimationEvent(Animation.COLOR_PICKER))));
    }

    private void addPrimaryColor() {
        DefaultLabel label = new DefaultLabel("primaryColor");
        Table table = new Table();
        table.add(label);
        updatePrimaryColor(table);
        Config.setOnPrimaryColorChange(() -> updatePrimaryColor(table));
        add(table);

    }

    private void addSecondaryColor() {
        DefaultLabel label = new DefaultLabel("secondaryColor");
        Table table = new Table();
        table.add(label);
        updateSecondaryColor(table);
        Config.setOnSecondaryColorChange(() -> updateSecondaryColor(table));
        add(table);
    }

    private void addBackgroundColor() {
        DefaultLabel label = new DefaultLabel("backgroundColor");
        Table table = new Table();
        table.add(label);
        updateBackgroundColor(table);
        Config.setOnBackgroundColorChange(() -> updateBackgroundColor(table));
        add(table);
    }


    private void updatePrimaryColor(Table table) {
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Config.getUserPrimaryColor());
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        table.setBackground(textureRegionDrawableBg);
    }

    private void updateSecondaryColor(Table table) {
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Config.getUserSecondaryColor());
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        table.setBackground(textureRegionDrawableBg);
    }

    private void updateBackgroundColor(Table table) {
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Config.getUserBackgroundColor());
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(new TextureRegion(new Texture(bgPixmap)));
        table.setBackground(textureRegionDrawableBg);
    }
}
