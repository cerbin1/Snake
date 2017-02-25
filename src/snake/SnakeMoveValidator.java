package snake;

import java.awt.*;

class SnakeMoveValidator {
    private final Snake snake;

    SnakeMoveValidator(Snake snake) {
        this.snake = snake;
    }

    boolean isMoveValid(int x, int y) {
        Point newHead = new Point(snake.getHead());
        newHead.move(x, y);

        return isPointInBoard(newHead) && isFieldEmptyOnPoint(newHead);
    }

    private boolean isPointInBoard(Point newHead) {
        return new Rectangle(0, 0, 39, 39).contains(newHead);
    }

    private boolean isFieldEmptyOnPoint(Point newHead) {
        return snake.getParts()
                .stream()
                .noneMatch(point -> point.equals(newHead));
    }
}
