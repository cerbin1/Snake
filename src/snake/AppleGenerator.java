package snake;

import java.awt.*;
import java.util.Random;

class AppleGenerator {
    private Point apple;
    private Random random = new Random();

    AppleGenerator() {
        apple = new Point(getRandomizedX(), getRandomizedY());
    }

    private int getRandomizedX() { // słabe te dwie metody. Nie wiem czemu
        return random.nextInt(38); // nie potrafie okreslic co jest w nich nie tak
    } // ale cos mnie w nich odrzuca. wydają się przekombinowane. robią to samo a nazywają się inaczej. i jest ich dwie.

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
