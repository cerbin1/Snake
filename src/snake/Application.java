package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Application implements ActionListener, KeyListener {
    private JPanel jPanel;
    private Point head;

    JFrame jFrame;

    Timer timer;

    int lengthOfTail = 5;

    int test = 0;

    private ArrayList<Point> snakeParts = new ArrayList<>();

    Application() {
        timer = new Timer(10, this);
        head = new Point(0, 0);
        jPanel = createJPanel();
        jFrame = createJFrame();
        jFrame.add(jPanel);
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
        System.out.println(test);
        if (isHeadOutOfBoard()) {
            timer.stop();
        }
        jPanel.removeAll();
        jPanel.add(new BoardAndSnakeDrawer(head, snakeParts));
        head = new Point(head.x + 1, head.y);
        test++;
        jPanel.repaint();
        jPanel.revalidate();
        if (snakeParts.size() > lengthOfTail) {
            snakeParts.remove(0);
        }
    }

    private boolean isHeadOutOfBoard() {
        return (head.x + 1 >= jPanel.getWidth() - 10 || head.x + 1 <= 0) || (head.y + 1 >= jPanel.getHeight() - 10 || head.y + 1 <= 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            timer.stop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Application());
    }
}
