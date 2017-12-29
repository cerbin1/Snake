package snake;

import View.GameFrame;
import View.RenderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_SPACE;
import static snake.Direction.*;

class Application implements ActionListener, KeyListener {
    private final Timer timer;
    private final Snake snake;
    private final RenderPanel renderPanel;
    private final GameFrame gameFrame;

    private Direction direction = DOWN;
    private boolean gameEnded;

    Application(int difficulty, int width, int height, int snakeSize) {
        int refreshRate = Difficulty.values()[difficulty].getDifficulty();
        timer = new Timer(refreshRate, this);
        Size size = new Size(width, height);
        AppleGenerator appleGenerator = new AppleGenerator(size);
        snake = new Snake(snakeSize, size, appleGenerator);
        renderPanel = new RenderPanel(snake.getParts(), appleGenerator.getApple(), size);
        gameFrame = new GameFrame(this, renderPanel, size);
        runGame();
    }

    private void runGame() {
        gameFrame.show();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.moveTo(direction);
        if (snake.isDead()) {
            endGame();
        }
    }

    private void endGame() {
        timer.stop();
        gameEnded = true;
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
        if (!gameEnded) {
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
}
