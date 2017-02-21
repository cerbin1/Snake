package snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static snake.Direction.*;

public class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private Timer timer;
    private AppleGenerator appleGenerator;
    private GameFrame gameFrame;

    private Snake snake;

    private Application() {
        timer = new Timer(50, this);
        snake = new Snake(5);
        appleGenerator = new AppleGenerator();
        renderPanel = new RenderPanel(snake.getSnakeParts(), appleGenerator.getApple());
        gameFrame = new GameFrame(this, renderPanel);
        gameFrame.display();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.addHead();

        if (snake.getHead().equals(appleGenerator.getApple())) {
            snake.increaseTail();
            appleGenerator.relocateApple();
            System.out.println("zjadlem");
        }
        direction.move(snake, this);

        if (snake.getSnakeParts().size() > snake.getLengthOfTail()) {
            snake.getSnakeParts().remove(0);
        }
    }


    void stopGame() {
        timer.stop();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == VK_SPACE) {
            if (timer.isRunning()) {
                stopGame();
            } else {
                timer.start();
            }
        }
        if (keyCode == VK_DOWN && direction != UP) {
            direction = DOWN;
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
        SwingUtilities.invokeLater(Application::new);
    }
}
