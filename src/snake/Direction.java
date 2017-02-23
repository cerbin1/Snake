package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);
    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
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
}
