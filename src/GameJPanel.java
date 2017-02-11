import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameJPanel {
    private Head head;
    private JPanel jPanel;

    GameJPanel(Head head) {
        this.head = head;
    }

    JPanel createJPanel() {
        jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(new Dimension(400, 400));
        jPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
        jPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 37) {
                    System.out.println("lewo");
                    head.setX(head.getX() - 5);
                    jPanel.removeAll();
                    jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 39) {
                    System.out.println("prawo");
                    head.setX(head.getX() + 5);
                    jPanel.removeAll();
                    jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 40) {
                    System.out.println("dol");
                    head.setY(head.getY() + 5);
                    jPanel.removeAll();
                    jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
                    jPanel.revalidate();
                    jPanel.repaint();
                }

                if (e.getKeyCode() == 38) {
                    System.out.println("gora");
                    head.setY(head.getY() - 5);
                    jPanel.removeAll();
                    jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
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
