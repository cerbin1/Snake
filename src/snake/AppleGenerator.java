package snake;

import java.awt.*;
import java.util.List;
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

    void relocateApple(List<Point> snakeParts) {
        while (true) {
            Point applePosition = getRandomPoint();
            if (isAppleNotGeneratedOnSnake(snakeParts, applePosition)) {
                apple.setLocation(getRandomNumberNotExceeding(bottomEdge), getRandomNumberNotExceeding(rightEdge));
                break;
            }
        }
    }

    private boolean isAppleNotGeneratedOnSnake(List<Point> snakeParts, Point applePosition) {
        return snakeParts.stream().noneMatch(point -> point.equals(applePosition));
    }
}
