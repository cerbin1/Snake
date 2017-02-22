package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private Random random = new Random();

    AppleGenerator() {
        apple = new Point(getRandomNumber(38), getRandomNumber(38));
    }

    private int getRandomNumber(int maxNumber) {
        return random.nextInt(maxNumber);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(getRandomNumber(38), getRandomNumber(38));
    }
}
