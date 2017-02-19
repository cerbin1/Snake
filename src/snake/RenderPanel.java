package snake;

import javax.swing.*;
import java.awt.*;
import java.util.List;

class RenderPanel extends JPanel {

    private List<Point> snakeParts;

    private static int color = 0;

    private Point apple;

    RenderPanel(List<Point> snakeParts, Point apple) {
        this.snakeParts = snakeParts;
        this.apple = apple;
        new JPanel();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void paint(Graphics g) {
        drawBoard(g);
        drawSnake(g);
        drawApple(g);
        color++;
    }

    private void drawApple(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(apple.x * 10, apple.y * 10, 10, 10);
    }

    private void drawBoard(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(new Color(color));
        g.fillRect(0, 0, 400, 400);
    }

    private void drawSnake(Graphics g) {
        for (Point point : snakeParts) {
            g.setColor(Color.green);
            g.fillRect(point.x * 10, point.y * 10, 10, 10);
        }
    }
}
