package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private final Point apple;
    private final Random random = new Random();
    private final int bottomEdge;
    private final int rightEdge;

    AppleGenerator(int width, int height) {
        rightEdge = width / 10 - 2;
        bottomEdge = height / 10 - 2;
        apple = new Point(getRandomNumberNotExceeding(bottomEdge), getRandomNumberNotExceeding(rightEdge));
    }

    private int getRandomNumberNotExceeding(int maxNumber) {
        return random.nextInt(maxNumber);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(getRandomNumberNotExceeding(bottomEdge), getRandomNumberNotExceeding(rightEdge));
    }
}
