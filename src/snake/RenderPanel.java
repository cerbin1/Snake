package snake;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.awt.Color.*;

class RenderPanel extends JPanel {
    private List<Point> snakeParts;
    private int color = 0;
    private Point apple;

    RenderPanel(List<Point> snakeParts, Point apple) {
        this.snakeParts = snakeParts;
        this.apple = apple;
        this.setPreferredSize(new Dimension(400, 400));
    }

    public void paint(Graphics g) {
        drawBoard(g);
        drawSnake(g);
        drawApple(g);
        color++;
    }

    private void drawBoard(Graphics g) {
        g.drawRect(0, 0, 400, 400);
        g.setColor(new Color(color));
        g.fillRect(0, 0, 400, 400);
    }

    private void drawSnake(Graphics g) {
        snakeParts.forEach(point -> {
            g.setColor(green);
            g.fillRect(point.x * 10, point.y * 10, 10, 10);
        });
    }

    private void drawApple(Graphics g) {
        g.setColor(red);
        g.fillRect(apple.x * 10, apple.y * 10, 10, 10);
    }
}
