package com.visualg.ui.upRightMenu;

import com.visualg.ui.simplifiedComponents.DefaultButton;

import static com.visualg.global.Config.musicController;

public class MuteMusicButton extends DefaultButton {

    private static MuteMusicButton INSTANCE;

    public MuteMusicButton() {
        super("mute", () -> onChange(INSTANCE));
        INSTANCE = this;
    }

    private static void onChange(MuteMusicButton muteMusicButton) {
        if (musicController.isPlaying()) {
            musicController.mute();
            muteMusicButton.setText("unmute");
        } else {
            musicController.unmute();
            muteMusicButton.setText("mute");
        }
    }
}
