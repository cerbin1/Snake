package snake;

import static java.awt.event.KeyEvent.*;
import static java.util.Arrays.stream;

enum Direction {
    DOWN(0, 1, VK_DOWN), UP(0, -1, VK_UP), LEFT(-1, 0, VK_LEFT), RIGHT(1, 0, VK_RIGHT);

    private final int x, y, keyCode;

    Direction(int x, int y, int keyCode) {
        this.x = x;
        this.y = y;
        this.keyCode = keyCode;
    }

    public boolean isOpposite(Direction direction) {
        return direction.x == -x && direction.y == -y;
    }

    public static Direction fromKeyCode(int keyCode) {
        return stream(values())
                .filter(direction -> direction.keyCode == keyCode)
                .findAny()
                .get();
    }

    public static boolean isDirection(int keyEvent) {
        return stream(values()).anyMatch(direction -> direction.keyCode == keyEvent);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
