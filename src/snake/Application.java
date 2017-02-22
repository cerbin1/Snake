package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static javax.swing.SwingUtilities.invokeLater;
import static snake.Direction.*;

public class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private AppleGenerator appleGenerator;
    private GameFrame gameFrame;
    private TimerManager timerManager;

    private Snake snake;

    private Application() {
        initializeComponents();
        gameFrame.display();
        timerManager.startTimer();
    }

    private void initializeComponents() {
        timerManager = new TimerManager(this);
        snake = new Snake(5);
        appleGenerator = new AppleGenerator();
        renderPanel = new RenderPanel(snake.getSnakeParts(), appleGenerator.getApple());
        gameFrame = new GameFrame(this, renderPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.addHead();

        if (snake.getHead().equals(appleGenerator.getApple())) {
            snake.increaseTail();
            appleGenerator.relocateApple();
        }
        direction.move(snake, timerManager);

        if (isTailOfSnakeTooLong()) {
            removeLastPart();
        }
    }

    private boolean isTailOfSnakeTooLong() {
        return snake.getSnakeParts().size() > snake.getLengthOfTail();
    }

    private void removeLastPart() {
        snake.getSnakeParts().remove(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == VK_SPACE) {
            if (timerManager.isTimerRunning()) { // ten cały if mógłby być w metodzie
                timerManager.stopTimer();        // timerManager.toggle()
            } else {
                timerManager.startTimer();
            }
        }
        if (keyCode == VK_DOWN && direction != UP) { // z tymi czterema trzeba coś zrobić
            direction = DOWN;                       // może by corobić metodę direction.opposite() ?
        }
        if (keyCode == VK_UP && direction != DOWN) {
            direction = UP;
        }
        if (keyCode == VK_LEFT && direction != RIGHT) {
            direction = LEFT;
        }
        if (keyCode == VK_RIGHT && direction != LEFT) {
            direction = RIGHT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        invokeLater(Application::new);
    }
}
