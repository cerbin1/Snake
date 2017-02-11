package snake;

import snake.Board;

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
                    move(-5, 0);
                }

                if (e.getKeyCode() == 39) {
                    System.out.println("prawo");
                    move(5, 0);
                }

                if (e.getKeyCode() == 40) {
                    System.out.println("dol");
                    move(0, 5);
                }

                if (e.getKeyCode() == 38) {
                    System.out.println("gora");
                    move(0, -5);
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

    private void move(int x, int y) {
        head.setX(head.getX() + x);
        head.setY(head.getY() + y);
        jPanel.removeAll();
        jPanel.add(new Board(head.getX(), head.getY()), BorderLayout.CENTER);
        jPanel.revalidate();
        jPanel.repaint();
    }
}
