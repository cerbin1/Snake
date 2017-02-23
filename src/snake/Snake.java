package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head = new Point(0, 0);
    private int length;
    private List<Point> parts = new LinkedList<>();
    private SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(this);

    Snake(int length) {
        this.length = length;
    }

    void setHead(Point head) {
        this.head = head;
    }

    void addHead() {
        parts.add(head);
    }

    Point getHead() {
        return head;
    }

    private int getLength() { // może samo getLength()?
        return length;
    }

    List<Point> getParts() {
        return parts;
    }

    void increaseLength() {
        length += 1;
    }

    boolean isAbleToMove(int x, int y) {
        return snakeMoveValidator.isInsideOfBoardVerticalOrHorizontal(x, y);
    }

    void resizeIfNeeded() {
        if(isLastPartOutOfSnake()) {
            removeLastPart();
        }
    }

    private boolean isLastPartOutOfSnake() {
        return parts.size() > length;
    }

    private void removeLastPart() {
        parts.remove(0);
    }

}
