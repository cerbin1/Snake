package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);
    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Snake snake, Application application) { // ruszenie węża spoko, wszystko inne nie spoko. (sprawdzanie czy udeżył w coś powinno być gdzie indziej)
        if (isAbleToMove(snake)) {
            addNewSnakePart(snake);
        } else {
            application.endGame();
        }
    }

    private boolean isAbleToMove(Snake snake) { // Czemu time ma umieć stwierdzić czy snake się może ruszyć?
        return isInsideOfBoardVerticalOrHorizontal(snake);
    }

    boolean isInsideOfBoardVerticalOrHorizontal(Snake snake) { // Czemu time ma umieć stwierdzić czy snake się może ruszyć?
        if (x == 0) {
            return isInsideOfBoardHorizontal(snake);
        } else {
            return isInsideOfBoardVertical(snake);
        }
    }

    private boolean isInsideOfBoardHorizontal(Snake snake) { // Czemu time ma umieć stwierdzić czy snake się może ruszyć?
        int nextPartOfSnake = snake.getHead().y + y;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !snake.isPartOfSnakeOnPoint(x, y);
    }

    private boolean isInsideOfBoardVertical(Snake snake) { // Czemu time ma umieć stwierdzić czy snake się może ruszyć?
        int nextPartOfSnake = snake.getHead().x + x;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !snake.isPartOfSnakeOnPoint(x, y);
    }

    private void addNewSnakePart(Snake snake) {
        Point newSnakeHead = new Point(snake.getHead().x + x, snake.getHead().y + y);
        snake.setHead(newSnakeHead);
    }
}
