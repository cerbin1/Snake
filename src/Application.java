import javax.swing.*;
import java.awt.*;

public class Application extends JComponent{
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawRect(10, 10, 200, 200);
    }
}
