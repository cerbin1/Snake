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
    private GameFrame gameFrame;

    private boolean ended;

    Application() {
        runApplication();
    }

    private void runApplication() {
        initializeComponents();
        gameFrame.display();
        timer.start();
    }

    private void initializeComponents() {
        timer = new Timer(50, this);

        Size size = new Size(40, 40);
        AppleGenerator appleGenerator = new AppleGenerator(size);
        snake = new Snake(5, size, appleGenerator);
        renderPanel = new RenderPanel(snake.getParts(), appleGenerator.getApple(), size);
        gameFrame = new GameFrame(this, renderPanel, size);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.moveTo(direction);
        if (snake.isDead()) {
            endGame();
            ended = true;
        }
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
        if (!ended) {
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        invokeLater(Application::new);
    }
}
