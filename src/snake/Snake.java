package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head;
    private int lengthOfTail;
    private List<Point> snakeParts;

    Snake(int lengthOfTail) {
        head = new Point(0, 0);
        this.lengthOfTail = lengthOfTail;
        snakeParts = new LinkedList<>();
    }

    boolean isPartOfSnakeOnPoint(int x, int y) {
        return snakeParts.stream().anyMatch(point -> point.equals(
                new Point(head.x + x, head.y + y)));
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

    int getLengthOfTail() {
        return lengthOfTail;
    }

    List<Point> getSnakeParts() {
        return snakeParts;
    }

    void increaseTail() {
        lengthOfTail += 1;
    }
}
