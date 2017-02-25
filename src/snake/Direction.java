package snake;

import java.awt.*;

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

    public void move(Snake snake, Application application) {
        if (snake.isAbleToMove(x, y)) {
            addNewSnakePart(snake);
        } else {
            application.endGame();
        }
    }

    private void addNewSnakePart(Snake snake) {
        Point headAfterMove = new Point(snake.getHead().x + x, snake.getHead().y + y);
        snake.setHead(headAfterMove);
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
}
