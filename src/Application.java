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
//        frame.getContentPane().add(new MyCanvas(0));
        frame.setVisible(true);
        Graphics g = frame.getGraphics();
        g.setColor(Color.black);
        g.drawRect(0, 0, 100, 100);
        g.fillRect(0, 0, 100, 100);


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
