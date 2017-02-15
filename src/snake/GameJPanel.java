package snake;

import javax.swing.*;
import java.awt.*;

class GameJPanel {
    private Head head;

    private Application application;

    GameJPanel(Head head, Application application) {
        this.head = head;
        this.application = application;
    }

    JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(new Dimension(400, 400));
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        jPanel.add(new Board(head.getX(), head.getY(), application), BorderLayout.CENTER);
        jPanel.setFocusable(true);
        return jPanel;
    }
}
