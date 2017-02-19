package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static snake.Direction.*;

public class Application implements ActionListener, KeyListener {
    private JPanel jPanel;
    private Point head;

    private Direction direction = DOWN;

    private int lengthOfTail;

    private Timer timer;

    private ArrayList<Point> snakeParts = new ArrayList<>();

    private Application() {
        timer = new Timer(40, this);
        head = new Point(0, 0);
        jPanel = createJPanel();
        JFrame jFrame = createJFrame();
        Random random = new Random();
        Point cherry = new Point(random.nextInt(38), random.nextInt(38));
        jPanel.add(new BoardAndSnakeDrawer(head, snakeParts, cherry));
        jFrame.add(jPanel);
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

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(400, 400));
        jPanel.setMinimumSize(new Dimension(400, 400));
        jPanel.setMaximumSize(new Dimension(400, 400));
        jPanel.setFocusable(true);
        return jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jPanel.repaint();
        snakeParts.add(head);

        if (direction == DOWN) {
            if ((head.y + 1) * 10 >= jPanel.getHeight()) {
                timer.stop();
            } else
                head = new Point(head.x, head.y + 1);
        }
        if (direction == UP) {
            if (head.y - 1 < 0) {
                timer.stop();
            } else
                head = new Point(head.x, head.y - 1);
        }
        if (direction == LEFT) {
            if (head.x - 1 < 0) {
                timer.stop();
            } else
                head = new Point(head.x - 1, head.y);
        }
        if (direction == RIGHT) {
            if ((head.x + 1) * 10 >= jPanel.getWidth()) {
                timer.stop();
            } else
                head = new Point(head.x + 1, head.y);
        }

        if (snakeParts.size() > lengthOfTail) {
            snakeParts.remove(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (timer.isRunning()) {
                timer.stop();
            } else {
                timer.start();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction = DOWN;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction = UP;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = LEFT;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
