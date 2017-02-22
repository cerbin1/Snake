package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private Random random = new Random();
    private int bottomEdge;
    private int rightEdge;

    AppleGenerator(int width, int height) {
        bottomEdge = width / 10 - 2;
        rightEdge = height / 10 - 2;
        apple = new Point(getRandomNumber(bottomEdge), getRandomNumber(rightEdge));
    }

    private int getRandomNumber(int maxNumber) {
        return random.nextInt(maxNumber);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(getRandomNumber(bottomEdge), getRandomNumber(rightEdge));
    }
}
