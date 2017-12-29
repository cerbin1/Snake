package snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class ConfigurationMenuFrame extends JFrame {

    ConfigurationMenuFrame() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        addElementsToJFrame();

        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        setVisible(true);
        addKeyListener(createKeyListener());
        pack();
    }

    private KeyListener createKeyListener() {
        return new KeyListener() {
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
        };
    }

    private void addElementsToJFrame() {
        JPanel snakeSizePanel = new JPanel();
        snakeSizePanel.add(new JLabel("Snake size: "));
        JTextField snakeSizeTextField = new JTextField("5", 3);
        snakeSizePanel.add(snakeSizeTextField);


        JPanel gameBoardSizePanel = new JPanel();
        gameBoardSizePanel.add(new JLabel("Width: "));
        JTextField gameWidthTextField = new JTextField("40", 4);
        gameBoardSizePanel.add(gameWidthTextField);
        gameBoardSizePanel.add(new JLabel("Height: "));
        JTextField gameHeightTextField = new JTextField("40", 4);
        gameBoardSizePanel.add(gameHeightTextField);

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
            int snakeSize = Integer.parseInt(snakeSizeTextField.getText());
            int gameBoardWidth = Integer.parseInt(gameWidthTextField.getText());
            int gameBoardHeight = Integer.parseInt(gameHeightTextField.getText());
            int difficulty = difficultySlider.getValue();
            new Game(difficulty, gameBoardWidth, gameBoardHeight, snakeSize);
        });
        buttonsPanel.add(startGameButton);

        add(snakeSizePanel);
        add(gameBoardSizePanel);
        add(difficultyPanel);
        add(buttonsPanel);
    }

    public static void main(String[] args) {
        new ConfigurationMenuFrame();
    }
}
