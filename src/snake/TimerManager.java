package snake;

import javax.swing.*;
import java.awt.event.ActionListener;

class TimerManager { // Po co ta cała klasa skoro ma dokładnie taki sam interfejs?
    // dokładnie taki sam konstruktor i metody które robią dokladnie to smao?
    // czemu nie uzyc po prostu Timer zamiast TimerManager?
    private Timer timer; // final?

    TimerManager(ActionListener actionListener) {
        int delayBetweenTimerTick = 50; // delay between ticks ma w programowaniu bardzo konkretną nazwę
                                        // wymyśl, albo przescrolluj na sam dół, tam napisałem
        timer = new Timer(delayBetweenTimerTick, actionListener);
    }

    void startTimer() { // timer.startTimer() ? wtf? czemu nie timer.start() ?
        timer.start();
    }

    void stopTimer() {  // czemu nie timer.stop() ?
        timer.stop();
    }

    boolean isTimerRunning() {  // czemu nie timer.isRunning()?
        return timer.isRunning();
    }
}



























































































































// ta nazwa to: (scrolluj w dół)



















































// nazwa to: Interval




































// w górę
