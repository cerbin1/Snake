package snake;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

class Snake {
    private final List<Point> parts = new LinkedList<>();
    private final MoveValidator moveValidator;
    private final AppleGenerator appleGenerator;
    private int length;
    private boolean dead;

    Snake(int length, Size size, AppleGenerator appleGenerator) {
        this.length = length;
        this.moveValidator = new MoveValidator(parts, size);
        this.appleGenerator = appleGenerator;
        setSnakePosition();
    }

    private void setSnakePosition() {
        Point head = new Point(0, 0);
        parts.add(head);
    }

    List<Point> getParts() {
        return parts;
    }

    public void moveTo(Direction direction) {
        Point newHead = getPositionOfNewHeadAfterMove(direction);
        if (moveValidator.isMoveValidTo(newHead)) {
            parts.add(newHead);
            if (isAppleReached()) {
                increaseLength();
                appleGenerator.relocateApple(parts);
            }
            if (parts.size() > length) {
                parts.remove(0);
            }
        } else {
            dead = true;
        }
    }

    private Point getPositionOfNewHeadAfterMove(Direction direction) {
        Point oldHead = parts.get(parts.size() - 1);
        return new Point(oldHead.x + direction.getX(), oldHead.y + direction.getY());
    }

    private boolean isAppleReached() {
        return parts.get(parts.size() - 1).equals(appleGenerator.getApple());
    }

    private void increaseLength() {
        length += 1;
    }

    public boolean isDead() {
        return dead;
    }
}
