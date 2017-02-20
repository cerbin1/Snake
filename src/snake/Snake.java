package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private Point head;
    private int lengthOfTail;
    private List<Point> snakeParts;

    Snake() {
        head = new Point(0, 0);
        lengthOfTail = 5;
        snakeParts = new LinkedList<>();
    }

    boolean isPartOfSnakeOnPoint(int x, int y) {
        for (Point point : snakeParts) {
            if (point.equals(new Point(head.x + x, head.y + y))) {
                return true;
            }
        }
        return false;
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
