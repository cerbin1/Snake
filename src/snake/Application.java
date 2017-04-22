package snake;

import View.GameFrame;
import View.RenderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_SPACE;
import static javax.swing.SwingUtilities.invokeLater;
import static snake.Direction.*;
import static snake.Direction.DOWN;

class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private AppleGenerator appleGenerator;
    private GameFrame gameFrame;
    private Size size;

    private Timer timer;

    private Snake snake;

    Application() {
        initializeComponents();
        gameFrame.display();
        timer.start();
    }

    private void initializeComponents() {
        size = new Size(40, 40);
        int interval = 50;
        timer = new Timer(interval, this);
        int numberOfSnakePartsOnStart = 5;
        snake = new Snake(numberOfSnakePartsOnStart, size);
        appleGenerator = new AppleGenerator(size);
        renderPanel = new RenderPanel(snake.getParts(), appleGenerator.getApple(), size);
        gameFrame = new GameFrame(this, renderPanel, size);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.addHead();

        if (isAppleReachedBySnake()) {
            snake.increaseLength();
            appleGenerator.relocateApple();
        }
        direction.move(snake, this);
        snake.resizeIfNeeded();
    }

    private boolean isAppleReachedBySnake() {
        return snake.getHead().equals(appleGenerator.getApple());
    }

    void endGame() {
        timer.stop();
    }

    Timer getTimer() {
        return timer;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == VK_SPACE) {
            timer.toggle();
            return;
        }
        if (isDirection(keyCode)) {
            Direction direction = fromKeyCode(keyCode);
            System.out.println(direction);
            if (!direction.isOpposite(this.direction)) {
                this.direction = direction;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        invokeLater(Application::new);
    }
}
