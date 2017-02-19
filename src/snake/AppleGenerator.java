package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private static Random random = new Random();

    AppleGenerator() {
        apple = new Point(random.nextInt(38), random.nextInt(38));
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(random.nextInt(38), random.nextInt(38));
    }
}
