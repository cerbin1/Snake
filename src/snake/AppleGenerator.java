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
        apple = new Point(getRandomNumberMaxAs(bottomEdge), getRandomNumberMaxAs(rightEdge));
    }

    private int getRandomNumberMaxAs(int maxNumber) {
        return random.nextInt(maxNumber);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(getRandomNumberMaxAs(bottomEdge), getRandomNumberMaxAs(rightEdge));
    }
}
