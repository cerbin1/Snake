import javax.swing.*;
import java.awt.*;

class BoardDrawer extends JComponent {
    public void paint(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 400, 400);
        g.drawRect(0, 0, 10, 10);
        g.setColor(Color.green);
        g.fillRect(0, 0, 10, 10);
    }
}
