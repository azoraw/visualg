package com.visualg.util;

import com.badlogic.gdx.utils.Timer;

public class Scheduler {
    public Scheduler(Runnable runnable, float periodInSeconds) {
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                runnable.run();
            }
        }, 0, periodInSeconds);
    }

    public Scheduler(Runnable runnable, float periodInSeconds, float offset) {
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                runnable.run();
            }
        }, offset, periodInSeconds);
    }
}
