package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private Random random = new Random();

    AppleGenerator() {
        apple = new Point(randomizeX(), randomizeY());
        System.out.println(apple);
    }

    private int randomizeX() {
        return random.nextInt(38);
    }

    private int randomizeY() {
        return random.nextInt(38);
    }

    Point getApple() {
        return apple;
    }

    void relocateApple() {
        apple.setLocation(randomizeX(), randomizeY());
        System.out.println(apple);
    }
}
