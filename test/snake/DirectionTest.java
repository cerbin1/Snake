package snake;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

public class DirectionTest {
    public @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    public void isDownMoveCorrect() {
        // before

        // when
        Direction direction = Direction.DOWN;

        // then
        Assert.assertEquals(0, direction.getX());
        Assert.assertEquals(1, direction.getY());
    }

    @Test
    public void isUpMoveCorrect() {
        // before

        // when
        Direction direction = Direction.UP;

        // then
        Assert.assertEquals(0, direction.getX());
        Assert.assertEquals(-1, direction.getY());
    }

    @Test
    public void isLeftMoveCorrect() {
        // before

        // when
        Direction direction = Direction.LEFT;

        // then
        Assert.assertEquals(-1, direction.getX());
        Assert.assertEquals(0, direction.getY());
    }

    @Test
    public void isRightMoveCorrect() {
        // before

        // when
        Direction direction = Direction.RIGHT;

        // then
        Assert.assertEquals(1, direction.getX());
        Assert.assertEquals(0, direction.getY());
    }

    @Test
    public void shouldReturnTrueWhenDirectionIsOpposite() {
        // before
        Direction direction = Direction.DOWN;

        // when
        boolean isOpposite = direction.isOpposite(Direction.UP);

        // then
        Assert.assertTrue(isOpposite);
    }

    @Test
    public void shouldReturnFalseWhenDirectionIsNotOpposite() {
        // before
        Direction direction = Direction.DOWN;

        // when
        boolean isOpposite = direction.isOpposite(Direction.RIGHT);

        // then
        Assert.assertFalse(isOpposite);
    }

    @Test
    public void shouldReturnDownDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(40);

        // then
        Assert.assertEquals(Direction.DOWN, direction);
    }

    @Test
    public void shouldReturnUpDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(38);

        // then
        Assert.assertEquals(Direction.UP, direction);
    }

    @Test
    public void shouldReturnLeftDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(37);

        // then
        Assert.assertEquals(Direction.LEFT, direction);
    }

    @Test
    public void shouldReturnRightDirectionFromKeyCode() {
        // when
        Direction direction = Direction.fromKeyCode(39);

        // then
        Assert.assertEquals(Direction.RIGHT, direction);
    }

    @Test
    public void shouldThrowExceptionWhenGettingUnexistingDirectionFromKeyCode() {
        expectedException.expect(NoSuchElementException.class);

        // when
        Direction.fromKeyCode(50);
    }
}