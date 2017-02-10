import javax.swing.*;

class GameBoard {

    void displayGameBoard() {
        JFrame frame = createJFrame();
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setVisible(true);
        return frame;
    }
}
