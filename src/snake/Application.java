package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import static java.awt.event.KeyEvent.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static snake.Direction.*;

public class Application implements ActionListener, KeyListener {
    private RenderPanel renderPanel;

    private Point head;
    private Direction direction = DOWN;

    private int lengthOfTail;

    private Timer timer;
    private AppleGenerator appleGenerator;

    private List<Point> snakeParts = new LinkedList<>();

    private Application() {
        timer = new Timer(50, this);
        head = new Point(0, 0);
        appleGenerator = new AppleGenerator();
        renderPanel = new RenderPanel(snakeParts, appleGenerator.getApple());
        JFrame jFrame = createJFrame();
        jFrame.add(renderPanel);
        jFrame.pack();
        timer.start();
        lengthOfTail = 5;
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
        snakeParts.add(head);

        if (head.equals(appleGenerator.getApple())) {
            lengthOfTail++;
            appleGenerator.relocateApple();
        }
        direction.move(this);

        if (snakeParts.size() > lengthOfTail) {
            snakeParts.remove(0);
        }
    }

    Point getHead() {
        return head;
    }

    void setHead(Point head) {
        this.head = head;
    }

    void stopGame() {
        timer.stop();
    }

    boolean isPartOfSnakeOnPoint(int x, int y) {
        for (Point point : snakeParts) {
            if (point.equals(new Point(head.x + x, head.y + y))) {
                return true;
            }
        }
        return false;
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
