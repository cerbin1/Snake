package View;

import snake.Size;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.awt.Color.*;

public class RenderPanel extends JPanel {
    private final List<Point> snakeParts;
    private final Point apple;
    private final int width, height;
    private int color = 0;

    public RenderPanel(List<Point> snakeParts, Point apple, Size size) {
        this.snakeParts = snakeParts;
        this.apple = apple;
        this.width = size.getWith() * 10;
        this.height = size.getHeight() * 10;
        this.setPreferredSize(new Dimension(width, height));
    }

    public void paint(Graphics g) {
        drawGameBoard(g);
        drawSnake(g);
        drawApple(g);
        color++;
    }

    private void drawGameBoard(Graphics g) {
        g.drawRect(0, 0, width, height);
        g.setColor(new Color(color));
        g.fillRect(0, 0, width, height);
    }

    private void drawSnake(Graphics g) {
        snakeParts.forEach(position -> {
            g.setColor(green);
            g.fillRect(position.x * 10, position.y * 10, 10, 10);
        });
    }

    private void drawApple(Graphics g) {
        g.setColor(red);
        g.fillRect(apple.x * 10, apple.y * 10, 10, 10);
    }
}
