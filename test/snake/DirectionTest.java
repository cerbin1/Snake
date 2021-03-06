package snake;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DirectionTest {
    public @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void isDownMoveCorrect() {
        // before

        // when
        Direction direction = Direction.DOWN;

        // then
        assertEquals(0, direction.getX());
        assertEquals(1, direction.getY());
    }

    @Test
    public void isUpMoveCorrect() {
        // before

        // when
        Direction direction = Direction.UP;

        // then
        assertEquals(0, direction.getX());
        assertEquals(-1, direction.getY());
    }

    @Test
    public void isLeftMoveCorrect() {
        // before

        // when
        Direction direction = Direction.LEFT;

        // then
        assertEquals(-1, direction.getX());
        assertEquals(0, direction.getY());
    }

    @Test
    public void isRightMoveCorrect() {
        // before

        // when
        Direction direction = Direction.RIGHT;

        // then
        assertEquals(1, direction.getX());
        assertEquals(0, direction.getY());
    }

    @Test
    public void shouldReturnTrueWhenDirectionIsOpposite() {
        // before
        Direction direction = Direction.DOWN;

        // when
        boolean isOpposite = direction.isOpposite(Direction.UP);

        // then
        assertTrue(isOpposite);
    }

    @Test
    public void shouldReturnFalseWhenDirectionIsNotOpposite() {
        // before
        Direction direction = Direction.DOWN;

        // when
        boolean isOpposite = direction.isOpposite(Direction.RIGHT);

        // then
        assertFalse(isOpposite);
    }

    @Test
    public void shouldReturnDownDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(40);

        // then
        assertEquals(Direction.DOWN, direction);
    }

    @Test
    public void shouldReturnUpDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(38);

        // then
        assertEquals(Direction.UP, direction);
    }

    @Test
    public void shouldReturnLeftDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(37);

        // then
        assertEquals(Direction.LEFT, direction);
    }

    @Test
    public void shouldReturnRightDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(39);

        // then
        assertEquals(Direction.RIGHT, direction);
    }

    @Test
    public void shouldThrowExceptionWhenGettingUnexistingDirectionFromKeyCode() {
        expectedException.expect(NoSuchElementException.class);

        // when
        Direction.fromKeyCode(50);
    }

    @Test
    public void shouldReturnTrueWhenButtonIsDirection() {
        // when
        boolean isDownDirection = Direction.isDirection(40);
        boolean isUpDirection = Direction.isDirection(38);
        boolean isLeftDirection = Direction.isDirection(37);
        boolean isRightDirection = Direction.isDirection(39);

        // then
        assertTrue(isDownDirection);
        assertTrue(isUpDirection);
        assertTrue(isLeftDirection);
        assertTrue(isRightDirection);
    }

    @Test
    public void shouldReturnFalseWhenButtonIsNotDirection() {
        // when
        boolean isNotDirection = Direction.isDirection(100);

        // then
        assertFalse(isNotDirection);
    }
}
