package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);

    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Snake snake, TimerManager timerManager) {
        if (horizontalOrVertical(snake, x, y)) {
            timerManager.stopTimer();
        } else {
            addNewSnakePart(snake, x, y);
        }
    }

    boolean horizontalOrVertical(Snake snake, int x, int y) {
        if (x == 0) {
            int nextPartOfSnake = snake.getHead().y + y;
            return nextPartOfSnake < 0 || nextPartOfSnake > 39 || snake.isPartOfSnakeOnPoint(x, y);
        } else {
            int nextPartOfSnake = snake.getHead().x + x;
            return nextPartOfSnake < 0 || nextPartOfSnake > 39 || snake.isPartOfSnakeOnPoint(x, y);
        }
    }

    private void addNewSnakePart(Snake snake, int x, int y) {
        snake.setHead(new Point(snake.getHead().x + x, snake.getHead().y + y));
    }
}
