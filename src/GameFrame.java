import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameFrame {
    private int x = 10, y = 10;

    JPanel createJPanel() {
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
