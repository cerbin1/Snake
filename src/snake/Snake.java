package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head = new Point(0, 0);
    private int length;
    private List<Point> snakeParts = new LinkedList<>();
    private SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(this);

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
        return snakeMoveValidator.isInsideOfBoardVerticalOrHorizontal(x, y);
    }
}
