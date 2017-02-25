package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head = new Point(0, 0);
    private int length;
    private final List<Point> parts = new LinkedList<>();
    private final SnakeMoveValidator snakeMoveValidator;

    Snake(int length, Size size) {
        this.length = length;
        this.snakeMoveValidator = new SnakeMoveValidator(this, size);
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

    List<Point> getParts() {
        return parts;
    }

    void increaseLength() {
        length += 1;
    }

    boolean isAbleToMove(int x, int y) {
        return snakeMoveValidator.isMoveValid(x, y);
    }

    void resizeIfNeeded() {
        if (isLastPartOutOfSnake()) {
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
