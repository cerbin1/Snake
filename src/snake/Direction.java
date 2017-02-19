package snake;

import java.awt.*;

enum Direction implements DirectionInterface {
    DOWN {
        @Override
        public void move(Application application) {
            if (horizontal(application, 0, 1)) {
                application.stopGame();
            } else {
                addNewSnakePart(application, 0, 1);
            }
        }
    }, UP {
        @Override
        public void move(Application application) {
            if (horizontal(application, 0, -1)) {
                application.stopGame();
            } else {
                addNewSnakePart(application, 0, -1);
            }
        }
    }, LEFT {
        @Override
        public void move(Application application) {
            if (vertical(application, -1, 0)) {
                application.stopGame();
            } else {
                addNewSnakePart(application, -1, 0);
            }
        }
    }, RIGHT {
        @Override
        public void move(Application application) {
            if (vertical(application, 1, 0)) {
                application.stopGame();
            } else {
                addNewSnakePart(application, 1, 0);
            }
        }
    };

    private static boolean horizontal(Application application, int x, int y) {
        int nextPartOfSnake = application.getHead().y + y;
        return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || application.isPartOfSnakeOnPoint(x, y);
    }

    private static boolean vertical(Application application, int x, int y) {
        int nextPartOfSnake = application.getHead().x + x;
        return nextPartOfSnake >= 40 || nextPartOfSnake < 0 || application.isPartOfSnakeOnPoint(x, y);
    }

    private static void addNewSnakePart(Application application, int x, int y) {
        application.setHead(new Point(application.getHead().x + x, application.getHead().y + y));
    }
}
