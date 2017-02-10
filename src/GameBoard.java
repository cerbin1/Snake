import javax.swing.*;
import java.awt.*;

class GameBoard {

    void displayGameBoard() {
        JFrame frame = createJFrame();
        JPanel jPanel = createJPanel();
        frame.add(jPanel);
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        return jPanel;
    }
}
