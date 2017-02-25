package snake;

import java.awt.*;

class SnakeMoveValidator {
    private final Snake snake;

    SnakeMoveValidator(Snake snake) {
        this.snake = snake;
    }

    boolean isInsideOfBoardVerticalOrHorizontal(int x, int y) {
        if (x == 0) {
            return isInsideOfBoardHorizontal(y) && !isNextFieldEmpty(x, y);
        } else {
            return isInsideOfBoardVertical(x) && !isNextFieldEmpty(x, y);
        }
    }

    boolean isInsideOfBoardHorizontal(int y) {
        int nextPartOfSnake = snake.getHead().y + y;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39);
    }

    boolean isInsideOfBoardVertical(int x) {
        int nextPartOfSnake = snake.getHead().x + x;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39);
    }

    boolean isNextFieldEmpty(int x, int y) {
        for (Point point : snake.getParts()) {
            if (point.equals(new Point(snake.getHead().x + x, snake.getHead().y + y))) {
                return false;
            }
        }
        return true;
    }
}
