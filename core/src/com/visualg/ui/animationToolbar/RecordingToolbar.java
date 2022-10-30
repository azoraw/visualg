package com.visualg.ui.animationToolbar;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.visualg.ui.simplifiedComponents.DefaultButton;
import com.visualg.ui.simplifiedComponents.DefaultLabel;
import com.visualg.util.libgdx.ScreenShotUtil;
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
        start = new DefaultButton("Start", ScreenShotUtil::prepareRecording);
        stop = new DefaultButton("Stop", ScreenShotUtil::finishRecording);
        schedule = new DefaultButton("Schedule", ScreenShotUtil::scheduleRecordingOnNextAnimationStart);
        frameCount = new DefaultLabel(ScreenShotUtil.getFrameCount() + " ");
        ScreenShotUtil.notifyOnFrameChanged(this::onFrameCountChange);
    }

    public void onFrameCountChange() {
        frameCount.setText(ScreenShotUtil.getFrameCount() + " ");
    }
}
