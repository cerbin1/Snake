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
    private Timer timer;

    private Snake snake;

    private Application() {
        initializeComponents();
        gameFrame.display();
        timer.start();
    }

    private void initializeComponents() {
        int interval = 50;
        timer = new Timer(interval, this);
        snake = new Snake(5);
        appleGenerator = new AppleGenerator(400, 400);
        renderPanel = new RenderPanel(snake.getSnakeParts(), appleGenerator.getApple());
        gameFrame = new GameFrame(this, renderPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.addHead();

        if (snake.getHead().equals(appleGenerator.getApple())) {
            snake.increaseLength();
            appleGenerator.relocateApple();
        }
        direction.move(snake, timer);

        if (isTailOutOfSnake()) {
            removeLastPart();
        }
    }

    private boolean isTailOutOfSnake() {
        return snake.getSnakeParts().size() > snake.getLength();
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
            timer.toggle();
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
