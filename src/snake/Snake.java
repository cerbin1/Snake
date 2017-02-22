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

    int getLength() { // może samo getLength()?
        return length;
    }

    List<Point> getSnakeParts() {
        return snakeParts;
    }

    void increaseLength() {
        length += 1;
    }
}
