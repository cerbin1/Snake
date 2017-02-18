package snake;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class BoardAndSnakeDrawer extends JComponent {
    private int x, y;

    private List<Point> snakeParts;

    private static int color = 0;

    BoardAndSnakeDrawer(Point head, List<Point> snakeParts) {
        x = head.x;
        y = head.y;
        this.snakeParts = snakeParts;
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(new Color(color));
        g.fillRect(0, 0, 400, 400);

        drawSnake(g);
        color++;
    }

    private void drawSnake(Graphics g) {
        for (Point point : snakeParts) {
            g.setColor(Color.green);
            g.fillRect(point.x * 10, point.y * 10, 10, 10);
        }
    }
}
