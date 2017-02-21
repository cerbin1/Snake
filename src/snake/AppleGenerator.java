package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private Random random = new Random();

    AppleGenerator() {
        apple = new Point(getRandomizedX(), getRandomizedY());
    }

    private int getRandomizedX() {
        return random.nextInt(38);
    }

    private int getRandomizedY() {
        return random.nextInt(38);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(getRandomizedX(), getRandomizedY());
    }
}
