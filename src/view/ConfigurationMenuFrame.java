package view;

import snake.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class ConfigurationMenuFrame extends JFrame {

    private JTextField gameWidthTextField;
    private JTextField gameHeightTextField;
    private JSlider difficultySlider;
    private JTextField snakeSizeTextField;

    public ConfigurationMenuFrame() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        addElementsToJFrame();

        setFrame();
    }

    private void setFrame() {
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
        snakeSizeTextField = new JTextField("5", 3);
        snakeSizePanel.add(snakeSizeTextField);


        JPanel gameBoardSizePanel = new JPanel();
        gameBoardSizePanel.add(new JLabel("Width: "));
        gameWidthTextField = new JTextField("40", 4);
        gameBoardSizePanel.add(gameWidthTextField);
        gameBoardSizePanel.add(new JLabel("Height: "));
        gameHeightTextField = new JTextField("40", 4);
        gameBoardSizePanel.add(gameHeightTextField);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.add(new JLabel("Difficulty: "));

        difficultySlider = new JSlider(0, 10, 5);
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
        startGameButton.addActionListener(e -> clickStartGameButton());
        buttonsPanel.add(startGameButton);

        add(snakeSizePanel);
        add(gameBoardSizePanel);
        add(difficultyPanel);
        add(buttonsPanel);
    }

    private void clickStartGameButton() {
        int gameBoardWidth = getValueOf(gameWidthTextField);
        int gameBoardHeight = getValueOf(gameHeightTextField);
        int snakeSize = getValueOf(snakeSizeTextField);
        int difficulty = difficultySlider.getValue();

        if (validateConfigurationValues(gameBoardWidth, gameBoardHeight, snakeSize)) {
            new Game(difficulty, gameBoardWidth, gameBoardHeight, snakeSize);
            setVisible(false);
        }
    }

    private boolean validateConfigurationValues(int gameBoardWidth, int gameBoardHeight, int snakeSize) {
        return 10 <= gameBoardWidth && gameBoardWidth <= 100 && 10 <= gameBoardHeight && gameBoardHeight <= 100 && 1 <= snakeSize && snakeSize <= gameBoardWidth * gameBoardHeight / 2;
    }

    private int getValueOf(JTextField textField) {
        int gameBoardWidth = -1;
        try {
            gameBoardWidth = Integer.parseInt(textField.getText());
            textField.setForeground(Color.black);
        } catch (NumberFormatException e) {
            System.err.println("Not a number!");
            textField.setForeground(Color.red);
        }
        return gameBoardWidth;
    }
}
