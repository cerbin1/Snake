package View;

import snake.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameFrame {
    private final KeyListener keyListener;
    private final RenderPanel renderPanel;
    private final int width, height;
    private JFrame jFrame;

    public GameFrame(KeyListener keyListener, RenderPanel renderPanel, Size size) {
        this.keyListener = keyListener;
        this.renderPanel = renderPanel;
        this.width = size.getWith() * 10;
        this.height = size.getHeight() * 10;
        jFrame = createJFrame();
    }

    public void show() {
        jFrame.setVisible(true);
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addKeyListener(keyListener);
        frame.setFocusable(true);
        frame.add(renderPanel);
        return frame;
    }
}
