import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel {
    int number;
    public MyCanvas(int n) {
        number = n;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, 300, 300);
        g.fillRect(0, 0, 300, 300);
        g.setColor(Color.white);
        g.drawRect(number, number, number + 10, number + 10);
        g.fillRect(number, number, number + 10, number + 10);
    }
}
