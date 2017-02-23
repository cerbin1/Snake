package snake;

import java.awt.*;

class SnakeMoveValidator {
    private final Snake snake;

    SnakeMoveValidator(Snake snake) {
        this.snake = snake;
    }

    boolean isInsideOfBoardVerticalOrHorizontal(int x, int y) {
        if (x == 0) {
            return isInsideOfBoardHorizontal(x, y);
        } else {
            return isInsideOfBoardVertical(x, y);
        }
    }

    private boolean isInsideOfBoardHorizontal(int x, int y) {
        int nextPartOfSnake = snake.getHead().y + y;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !isPartOfSnakeOnPoint(x, y);
    }

    private boolean isInsideOfBoardVertical(int x, int y) {
        int nextPartOfSnake = snake.getHead().x + x;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !isPartOfSnakeOnPoint(x, y);
    }

    private boolean isPartOfSnakeOnPoint(int x, int y) {
        return snake.getParts().stream().anyMatch(point -> point.equals(
                new Point(snake.getHead().x + x, snake.getHead().y + y)));
    }
}
