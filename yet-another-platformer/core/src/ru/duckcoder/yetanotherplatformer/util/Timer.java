package ru.duckcoder.yetanotherplatformer.util;

import lombok.Getter;

@Getter
public class Timer {
    private long millis;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;

    public static Timer fromMillis(long millis) {
        Timer timer = new Timer();
        timer.millis = millis;
        timer.milliseconds = (int) (millis % 1000);
        timer.seconds = (int) ((millis / 1000) % 60);
        timer.minutes = (int) ((millis / 60000) % 60);
        timer.hours = (int) (millis / 3600000);
        return timer;
    }

    public void updateFromMillis(long millis) {
        this.millis = millis;
        this.milliseconds = (int) (millis % 1000);
        this.seconds = (int) ((millis / 1000) % 60);
        this.minutes = (int) ((millis / 60000) % 60);
        this.hours = (int) (millis / 3600000);
    }

    public String toSimplifyString() {
        long s = seconds + minutes * 60L + hours * 60L * 60L;
        return s + "." + milliseconds;
    }

    @Override
    public String toString() {
        return hours + " h," +
                minutes + " m, " +
                seconds + " s, " +
                milliseconds + " ms";
    }
}
