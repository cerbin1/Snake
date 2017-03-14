package snake;

import java.awt.*;

class SnakeMoveValidator {
    private final Snake snake;
    private final int rightEdge, bottomEdge;

    SnakeMoveValidator(Snake snake, Size size) {
        this.snake = snake;
        rightEdge = size.getX() - 1;
        bottomEdge = size.getY() - 1;
    }

    boolean isMoveValid(int x, int y) {
        Point newHead = new Point(snake.getHead());
        newHead.move(snake.getHead().x + x, snake.getHead().y + y);

        return isPointInBoard(newHead) && isFieldEmptyOnPoint(newHead);
    }

    private boolean isPointInBoard(Point newHead) {
        return new Rectangle(0, 0, rightEdge, bottomEdge).contains(newHead);
    }

    private boolean isFieldEmptyOnPoint(Point newHead) {
        return snake.getParts()
                .stream()
                .noneMatch(point -> point.equals(newHead));
    }
}
