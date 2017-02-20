package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);

    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Snake snake, Application app) {
        if (horizontalOrVertical(snake, x, y)) {
            app.stopGame();
        } else {
            addNewSnakePart(snake, x, y);
        }
    }

    boolean horizontalOrVertical(Snake snake, int x, int y) {
        if (x == 0) {
            int nextPartOfSnake = snake.getHead().y + y;
            return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || snake.isPartOfSnakeOnPoint(x, y);
        } else {
            int nextPartOfSnake = snake.getHead().x + x;
            return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || snake.isPartOfSnakeOnPoint(x, y);
        }
    }

    private static void addNewSnakePart(Snake snake, int x, int y) {
        snake.setHead(new Point(snake.getHead().x + x, snake.getHead().y + y));
    }
}
