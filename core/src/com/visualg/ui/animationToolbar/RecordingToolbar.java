package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.visualg.controls.fileio.ScreenShotSaver;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import lombok.Getter;

@Getter
class RecordingToolbar {

    private final Label label;
    private final Label frameCount;
    private final TextButton start;
    private final TextButton stop;
    private final TextButton schedule;

    RecordingToolbar() {
        label = new DefaultLabel("Recording: ");
        start = new DefaultButton("Start", ScreenShotSaver::prepareRecording);
        stop = new DefaultButton("Stop", ScreenShotSaver::finishRecording);
        schedule = new DefaultButton("Schedule", ScreenShotSaver::scheduleRecordingOnNextAnimationStart);
        frameCount = new DefaultLabel(ScreenShotSaver.getFrameCount() + " ");
        ScreenShotSaver.notifyOnFrameChanged(this::onFrameCountChange);
    }

    public void onFrameCountChange() {
        frameCount.setText(ScreenShotSaver.getFrameCount() + " ");
    }
}
