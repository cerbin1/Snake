import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JComponent implements KeyListener{

    JFrame frame;
    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        frame = new JFrame("Snake");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        SwingUtilities.invokeLater(() -> {
            Graphics g = frame.getGraphics();
            while(true) {
                g.setColor(Color.black);
                g.drawRect(0, 0, 100, 100);
                g.fillRect(0, 0, 100, 100);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });



        frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == 32) {
            System.out.println("dobrze");
            frame.getContentPane().add(new MyCanvas(10));
        }
        else {
            System.out.println("dziala");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
*/
public class SwingPaintDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
        JFrame frame = new JFrame("Swing Paint Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new MyPanel());
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                    MyPanel panel = new MyPanel();
                    panel.moveSquare(50, 50);

                System.out.println(e.getKeyCode());
                System.out.println(e.getKeyChar());

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}

class MyPanel extends JPanel {
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 50;
    private int squareH = 50;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    public void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX != x) || squareY != y) {
            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
        }
    }


    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(Color.BLACK);
        g.fillRect(squareX, squareY, squareW, squareH);
    }
}