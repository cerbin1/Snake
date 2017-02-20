package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static snake.Direction.*;

public class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;
    private Direction direction = DOWN;
    private Timer timer;
    private AppleGenerator appleGenerator;

    private Snake snake;

    private Application() {
        timer = new Timer(50, this);
        snake = new Snake(new Point(0, 0));
        appleGenerator = new AppleGenerator();
        renderPanel = new RenderPanel(snake.getSnakeParts(), appleGenerator.getApple());
        JFrame jFrame = createJFrame();
        jFrame.add(renderPanel);
        jFrame.pack();
        timer.start();
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        snake.addHead();

        if (snake.getHead().equals(appleGenerator.getApple())) {
            snake.increaseTail();
            appleGenerator.relocateApple();
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
