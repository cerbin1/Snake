package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private final Point apple;
    private final Random random = new Random();
    private final int bottomEdge;
    private final int rightEdge;

    AppleGenerator(Size size) {
        rightEdge = size.getWith() - 2;
        bottomEdge = size.getHeight() - 2;
        apple = getRandomPoint();
    }

    Point getApple() {
        return apple;
    }

    private Point getRandomPoint() {
        return new Point(getRandomNumberNotExceeding(bottomEdge), getRandomNumberNotExceeding(rightEdge));
    }

    private int getRandomNumberNotExceeding(int maxNumber) {
        return random.nextInt(maxNumber);
    }

    void relocateApple() {
        apple.setLocation(getRandomNumberNotExceeding(bottomEdge), getRandomNumberNotExceeding(rightEdge));
    }
}
