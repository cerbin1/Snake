package snake;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveValidatorTest {
    @Test
    public void shouldReturnTrueWhenAfterMoveIsInBoard() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(5, 5));

        // then
        assertTrue(valid);
    }

    @Test
    public void shouldReturnFalseWhenNextMoveExceedBottomBorder() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(5, 10));

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNextMoveExceedTopBorder() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(5, -5));

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNextMoveExceedLeftBorder() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(-5, 5));

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNextMoveExceedRightBorder() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(10, 5));

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldReturnFalseWhenNextMoveConflictWithTail() {
        // given
        List<Point> snakeParts = new ArrayList<>();
        snakeParts.add(new Point(0, 0));
        snakeParts.add(new Point(1, 0));
        snakeParts.add(new Point(2, 0));
        snakeParts.add(new Point(3, 0));
        MoveValidator moveValidator = moveValidator(snakeParts);

        // when
        boolean valid = moveValidator.isMoveValidTo(new Point(2, 0));

        // then
        assertFalse(valid);
    }


    private static MoveValidator moveValidator(List<Point> snakeParts) {
        return new MoveValidator(snakeParts, new Size(10, 10));
    }
}
