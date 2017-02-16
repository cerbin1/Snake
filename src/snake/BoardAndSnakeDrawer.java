package snake;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class BoardAndSnakeDrawer extends JComponent {
    private int x, y;

    private List<Point> snakeParts;

    private static int color = 0;

    BoardAndSnakeDrawer(int x, int y, List<Point> snakeParts) {
        this.x = x;
        this.y = y;
        this.snakeParts = snakeParts;
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(new Color(color));
        g.fillRect(0, 0, 400, 400);
        g.drawRect(x, y, 10, 10);
        g.setColor(Color.green);
        g.fillRect(x, y, 10, 10);

        drawSnake(g);
        color++;
    }

    private void drawSnake(Graphics g) {
        for (Point point : snakeParts) {
            g.setColor(Color.green);
            g.fillRect(point.x, point.y, 10, 10);
        }
    }
}
