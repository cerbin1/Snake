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
    private Head head;

    JFrame jFrame;

    Timer timer;

    int lengthOfTail = 5;

    int test = 0;

    ArrayList<Point> snakeParts = new ArrayList<>();

    Application() {
        timer = new Timer(5, this);
        head = new Head(0, 0);
        jPanel = createJPanel();
        jFrame = createJFrame();
        jFrame.add(jPanel);
        timer.start();
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(new Dimension(400, 400));
        jPanel.add(new BoardAndSnakeDrawer(head.getX(), head.getY(), this), BorderLayout.CENTER);
        jPanel.setFocusable(true);
        return jPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(test);
        if(test + 40 > jFrame.getHeight()) {
            timer.stop();
        }
        jPanel.removeAll();
        jPanel.add(new BoardAndSnakeDrawer(head.getX(), head.getY(), this));
        snakeParts.add(new Point(head.getX(), head.getY() + test));
        test++;
        jPanel.repaint();
        jPanel.revalidate();
        if(snakeParts.size() > lengthOfTail) {
            snakeParts.remove(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Application());
    }
}
