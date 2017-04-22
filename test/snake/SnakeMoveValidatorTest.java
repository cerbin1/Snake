package snake;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SnakeMoveValidatorTest {
    @Test
    public void shouldSnakeWMoveWhenAfterMoveIsInBoard() {
        // given
        Snake snake = snake();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(4, 7);

        // then
        assertTrue(valid);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedBottomBorder() {
        // given
        Snake snake = snake();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(50, 0);

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedTopBorder() {
        // given
        Snake snake = snake();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(-12, 0);

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedRightBorder() {
        // given
        Snake snake = snake();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(0, 60);

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedLeftBorder() {
        // given
        Snake snake = snake();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(0, -5);

        // then
        assertFalse(valid);
    }

    @Test
    public void shouldSnakeWMoveWhenNextMoveConflictWithTail() {
        // given
        Snake snake = snake();
        snake.addHead();
        SnakeMoveValidator snakeMoveValidator = snakeMoveValidator(snake);

        // when
        boolean valid = snakeMoveValidator.isValid(0, 0);

        // then
        assertFalse(valid);
    }

    private static Snake snake() {
        return new Snake(10, new Size(40, 40));
    }

    private static SnakeMoveValidator snakeMoveValidator(Snake snake) {
        return new SnakeMoveValidator(snake, new Size(40, 40));
    }
}
