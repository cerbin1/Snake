package snake;

import java.awt.*;
import java.util.List;

class MoveValidator {
    private final List<Point> snakeParts;
    private final int rightEdge, bottomEdge;

    MoveValidator(List<Point> snakeParts, Size size) {
        this.snakeParts = snakeParts;
        rightEdge = size.getWith();
        bottomEdge = size.getHeight();
    }

    boolean isMoveValidTo(Point newHead) {
        return isInBoard(newHead) && isPointEmptyOn(newHead);
    }

    private boolean isInBoard(Point newHead) {
        return new Rectangle(0, 0, rightEdge, bottomEdge).contains(newHead);
    }

    private boolean isPointEmptyOn(Point newHead) {
        return snakeParts
                .stream()
                .noneMatch(point -> point.equals(newHead));
    }
}
