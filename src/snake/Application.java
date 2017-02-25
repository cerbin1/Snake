package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_SPACE;
import static javax.swing.SwingUtilities.invokeLater;
import static snake.Direction.DOWN;

class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private AppleGenerator appleGenerator;
    private GameFrame gameFrame;

    private Timer timer;

    private Snake snake;

    Application() {
        initializeComponents();
        gameFrame.display();
        timer.start();
    }

    private void initializeComponents() {
        int interval = 50;
        timer = new Timer(interval, this);
        int numberOfSnakePartsOnStart = 5;
        snake = new Snake(numberOfSnakePartsOnStart);
        appleGenerator = new AppleGenerator(400, 400);
        renderPanel = new RenderPanel(snake.getParts(), appleGenerator.getApple());
        gameFrame = new GameFrame(this, renderPanel);
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

        Direction direction = Direction.fromKeyCode(keyCode);
        if (!direction.isOpposite(this.direction)) {
            this.direction = direction;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        invokeLater(Application::new);
    }
}
