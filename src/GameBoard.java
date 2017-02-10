import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameBoard {

    void displayGameBoard() {
        JFrame frame = createJFrame();
        JPanel jPanel = createJPanel();
        frame.add(jPanel);
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(new Dimension(400, 400));
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        jPanel.add(new Board(), BorderLayout.CENTER);
        return jPanel;
    }
}
