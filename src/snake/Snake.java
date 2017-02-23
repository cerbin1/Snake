package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head = new Point(0, 0);
    private int length;
    private List<Point> snakeParts = new LinkedList<>();

    Snake(int length) {
        this.length = length;
    }

    void setHead(Point head) {
        this.head = head;
    }

    void addHead() {
        snakeParts.add(head);
    }

    Point getHead() {
        return head;
    }

    int getLength() { // może samo getLength()?
        return length;
    }

    List<Point> getSnakeParts() {
        return snakeParts;
    }

    void increaseLength() {
        length += 1;
    }

    boolean isAbleToMove(int x, int y) {
        return isInsideOfBoardVerticalOrHorizontal(x, y);
    }

    private boolean isInsideOfBoardVerticalOrHorizontal(int x, int y) {
        if (x == 0) {
            return isInsideOfBoardHorizontal(x, y);
        } else {
            return isInsideOfBoardVertical(x, y);
        }
    }

    private boolean isInsideOfBoardHorizontal(int x, int y) {
        int nextPartOfSnake = getHead().y + y;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !isPartOfSnakeOnPoint(x, y);
    }

    private boolean isInsideOfBoardVertical(int x, int y) {
        int nextPartOfSnake = getHead().x + x;
        return (0 <= nextPartOfSnake && nextPartOfSnake <= 39) && !isPartOfSnakeOnPoint(x, y);
    }

    private boolean isPartOfSnakeOnPoint(int x, int y) {
        return snakeParts.stream().anyMatch(point -> point.equals(
                new Point(head.x + x, head.y + y)));
    }
}
