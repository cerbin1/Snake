import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Application implements ActionListener{
    private JPanel jPanel;
    private Head head;

    private Application() {
        Timer timer = new Timer(10, this);
        head = new Head(10, 10);
        jPanel = new GameJPanel(head).createJPanel();
        displayFrame();
        timer.start();
    }

    private void displayFrame() {
        JFrame jFrame = createJFrame();
        jFrame.add(jPanel);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Application());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("dupa");
        jPanel.removeAll();
        head.setY(head.getY() + 5);
        jPanel.add(new Board(head.getX(), head.getY()));
        jPanel.repaint();
        jPanel.revalidate();
    }
}
