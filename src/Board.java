import javax.swing.*;
import java.awt.*;

class Board extends JComponent {
    private int x, y;

    Board(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 400, 400);
        g.drawRect(x, y, 10, 10);
        g.setColor(Color.green);
        g.fillRect(x, y, 10, 10);
    }
}
