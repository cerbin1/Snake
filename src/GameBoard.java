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
        frame.setVisible(true);
        return frame;
    }

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setSize(30, 40);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        return jPanel;
    }
}
