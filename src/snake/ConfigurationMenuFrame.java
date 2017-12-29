package snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class ConfigurationMenuFrame extends JFrame {

    private ConfigurationMenuFrame() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel snakeSizePanel = new JPanel();
        snakeSizePanel.add(new JLabel("Snake size: "));
        snakeSizePanel.add(new JTextField(3));


        JPanel gameBoardSizePanel = new JPanel();
        gameBoardSizePanel.add(new JLabel("Width: "));
        gameBoardSizePanel.add(new JTextField(4));
        gameBoardSizePanel.add(new JLabel("Height: "));
        gameBoardSizePanel.add(new JTextField(4));

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.add(new JLabel("Difficulty: "));

        JSlider difficultySlider = new JSlider(0, 10, 5);
        difficultySlider.setMajorTickSpacing(5);
        difficultySlider.setMinorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setPaintLabels(true);
        difficultyPanel.add(difficultySlider);


        JPanel buttonsPanel = new JPanel();
        JButton exitGameButton = new JButton("Exit Game");
        exitGameButton.addActionListener(e -> System.exit(0));
        buttonsPanel.add(exitGameButton);

        JButton startGameButton = new JButton("Start the Game");
        startGameButton.addActionListener(e -> {
            setVisible(false);
            new Application();
        });
        buttonsPanel.add(startGameButton);

        add(snakeSizePanel);
        add(gameBoardSizePanel);
        add(difficultyPanel);
        add(buttonsPanel);

        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == VK_ESCAPE) {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        pack();
    }

    public static void main(String[] args) {
        new ConfigurationMenuFrame();
    }
}
