package snake;

import javax.swing.*;
import java.awt.event.ActionListener;

class TimerManager {
    private Timer timer;

    TimerManager(ActionListener actionListener) {
        int delayBetweenTimerTick = 50;
        timer = new Timer(delayBetweenTimerTick, actionListener);
    }

    void startTimer() {
        timer.start();
    }

    void stopTimer() {
        timer.stop();
    }

    boolean isTimerRunning() {
        return timer.isRunning();
    }
}
