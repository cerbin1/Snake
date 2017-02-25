package View;

import snake.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameFrame {
    private final KeyListener keyListener;
    private final RenderPanel renderPanel;
    private int width, height;

    public GameFrame(KeyListener keyListener, RenderPanel renderPanel, Size size) {
        this.keyListener = keyListener;
        this.renderPanel = renderPanel;
        this.width = size.getX() * 10;
        this.height = size.getY() * 10;
    }

    public void display() {
        JFrame jFrame = createJFrame();
        jFrame.add(renderPanel);
        jFrame.pack();
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(keyListener);
        frame.setFocusable(true);
        frame.setVisible(true);
        return frame;
    }
}