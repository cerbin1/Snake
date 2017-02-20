package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private static Random random = new Random();
    
    private int randomizedX = random.nextInt(38);
    private int randomizedY = random.nextInt(38);

    AppleGenerator() {
        apple = new Point(randomizedX, randomizedY);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(randomizedX, randomizedY);
    }
}
