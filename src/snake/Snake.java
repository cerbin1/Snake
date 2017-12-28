package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private final List<Point> parts = new LinkedList<>();
    private final MoveValidator moveValidator;
    private AppleGenerator appleGenerator;
    private int length;
    private boolean dead;

    Snake(int length, Size size, AppleGenerator appleGenerator) {
        this.length = length;
        this.moveValidator = new MoveValidator(parts, size);
        this.appleGenerator = appleGenerator;
        setSnakePosition();
    }

    private void setSnakePosition() {
        Point head = new Point(10, 10);
        parts.add(head);
    }

    List<Point> getParts() {
        return parts;
    }

    private boolean isLastPartOutOfSnake() {
        return parts.size() > length;
    }

    private void removeLastPart() {
        parts.remove(0);
    }

    public void move(Direction direction) {
        Point newHead = getNewHead(direction.getX(), direction.getY());
        if (moveValidator.isValidMoveTo(newHead)) {
            parts.add(newHead);
            if (isAppleReachedBySnake()) {
                increaseLength();
                appleGenerator.relocateApple();
            }
            if (isLastPartOutOfSnake()) {
                removeLastPart();
            }
        } else {
            dead = true;
        }
    }

    private Point getNewHead(int x, int y) {
        return new Point(parts.get(parts.size() - 1).x + x, parts.get(parts.size() - 1).y + y);
    }

    private boolean isAppleReachedBySnake() {
        return parts.get(0).equals(appleGenerator.getApple());
    }


    private void increaseLength() {
        length += 1;
    }

    public boolean isDead() {
        return dead;
    }
}
