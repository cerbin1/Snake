package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);
    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Snake snake, Timer timer) {
        if (isAbleToMove(snake)) {
            addNewSnakePart(snake);
        } else {
            timer.stop();
        }
    }

    private boolean isAbleToMove(Snake snake) {
        return isInsideOfBoardVerticalOrHorizontal(snake);
    }

    boolean isInsideOfBoardVerticalOrHorizontal(Snake snake) {
        if (x == 0) {
            return isInsideOfBoardHorizontal(snake);
        } else {
            return isInsideOfBoardVertical(snake);
        }
    }

    private boolean isInsideOfBoardHorizontal(Snake snake) {
        int nextPartOfSnake = snake.getHead().y + y;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !snake.isPartOfSnakeOnPoint(x, y);
    }

    private boolean isInsideOfBoardVertical(Snake snake) {
        int nextPartOfSnake = snake.getHead().x + x;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !snake.isPartOfSnakeOnPoint(x, y);
    }

    private void addNewSnakePart(Snake snake) {
        Point newSnakeHead = new Point(snake.getHead().x + x, snake.getHead().y + y);
        snake.setHead(newSnakeHead);
    }
}
