import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Application {

    private void displayFrame() {
        JFrame jFrame = createJFrame();
        jFrame.add(new GameFrame().createJPanel());
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
        SwingUtilities.invokeLater(() -> new Application().displayFrame());
    }
}
