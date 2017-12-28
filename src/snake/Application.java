package snake;

import View.GameFrame;
import View.RenderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_SPACE;
import static javax.swing.SwingUtilities.invokeLater;
import static snake.Direction.*;

class Application implements ActionListener, KeyListener {
    private Timer timer;
    private Snake snake;

    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private AppleGenerator appleGenerator;
    private GameFrame gameFrame;


    Application() {
        initializeComponents();
        gameFrame.display();
        timer.start();
    }

    private void initializeComponents() {
        Size size = new Size(40, 40);

        timer = new Timer(50, this);
        snake = new Snake(5, size);
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
        if (!direction.move(snake)) {
            endGame();
        }
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
        if (keyCode == VK_ESCAPE) {
            System.exit(0);
        }
        if (keyCode == VK_SPACE) {
            timer.toggle();
            return;
        }
        if (isDirection(keyCode)) {
            Direction direction = fromKeyCode(keyCode);
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
