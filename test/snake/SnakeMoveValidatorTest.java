package snake;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SnakeMoveValidatorTest {
    private final int lengthOfSnake = 10;

    @Test
    public void shouldSnakeWMoveWhenAfterMoveIsInBoard() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(4, 7);

        // then
        assertTrue(validator);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedBottomBorder() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(50, 0);

        // then
        assertFalse(validator);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedTopBorder() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(-12, 0);

        // then
        assertFalse(validator);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedRightBorder() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(0, 60);

        // then
        assertFalse(validator);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveExceedLeftBorder() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(0, -5);

        // then
        assertFalse(validator);
    }

    @Test
    public void shouldSnakeWMoveWhenNextMoveConflictWithTail() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        snake.addHead();
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        boolean validator = snakeMoveValidator.isMoveValid(0, 0);

        // then
        assertFalse(validator);
    }
}
