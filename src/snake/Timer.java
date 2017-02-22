package snake;

import java.awt.event.ActionListener;

class Timer extends javax.swing.Timer {
    Timer(int interval, ActionListener actionListener) {
        super(interval, actionListener);
    }

    void toggle() {
        if (isRunning()) {
            stop();
        } else {
            start();
        }
    }
}