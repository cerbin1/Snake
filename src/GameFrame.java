import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class GameFrame {
    private int x = 10, y = 10;

    void displayGameFrame() {
        JFrame frame = createJFrame();
        frame.setContentPane(createJPanel());
    }

    private JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    private JPanel createJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(new Dimension(400, 400));
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        jPanel.add(new Board(x, y), BorderLayout.CENTER);
        jPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    System.out.println("lewo");
                    jPanel.removeAll();
                    jPanel.add(new Board(x -= 5, y), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 39) {
                    System.out.println("prawo");
                    jPanel.removeAll();
                    jPanel.add(new Board(x += 5, y), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 40) {
                    System.out.println("dol");
                    jPanel.removeAll();
                    jPanel.add(new Board(x, y += 5), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 38) {
                    System.out.println("gora");
                    jPanel.removeAll();
                    jPanel.add(new Board(x, y -= 5), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });
        jPanel.setFocusable(true);
        return jPanel;
    }
}
