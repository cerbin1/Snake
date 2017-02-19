package snake;

import java.awt.*;

enum Direction {
    DOWN(0, 1), UP(0, -1), LEFT(-1, 0), RIGHT(1, 0);

    private int x, y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Application app) {
        if (horizontalOrVertical(app, x, y)) {
            app.stopGame();
        } else {
            addNewSnakePart(app, x, y);
        }
    }

    boolean horizontalOrVertical(Application app, int x, int y) {
        if (x == 0) {
            int nextPartOfSnake = app.getHead().y + y;
            return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || app.isPartOfSnakeOnPoint(x, y);
        } else {
            int nextPartOfSnake = app.getHead().x + x;
            return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || app.isPartOfSnakeOnPoint(x, y);
        }
    }

    private static void addNewSnakePart(Application application, int x, int y) {
        application.setHead(new Point(application.getHead().x + x, application.getHead().y + y));
    }
}
