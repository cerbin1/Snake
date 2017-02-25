package snake;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class SnakeMoveValidatorTest {
    private int lengthOfSnake = 10;

    @Test
    public void shouldSnakeWMoveWhenNextMoveNotExceedBoard() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        snake.setHead(new Point(4, 2));

        // then
        assertEquals(snakeMoveValidator.isInsideOfBoardHorizontal(4), true);
        assertEquals(snakeMoveValidator.isInsideOfBoardVertical(15), true);
    }

    @Test
    public void shouldSnakeMoveWhenNextMoveIsOnBorderOfBoard() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        snake.setHead(new Point(-5, 55));

        // then
        assertEquals(snakeMoveValidator.isInsideOfBoardVertical(5), true);
        assertEquals(snakeMoveValidator.isInsideOfBoardVertical(44), true);
        assertEquals(snakeMoveValidator.isInsideOfBoardHorizontal(-16), true);
        assertEquals(snakeMoveValidator.isInsideOfBoardHorizontal(-55), true);
    }

    @Test
    public void shouldSnakeWMoveWhenNextMoveExceedBoard() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        snake.setHead(new Point(0, 0));

        // then
        assertEquals(snakeMoveValidator.isInsideOfBoardVertical(-5), false);
        assertEquals(snakeMoveValidator.isInsideOfBoardVertical(154), false);
        assertEquals(snakeMoveValidator.isInsideOfBoardHorizontal(-23), false);
        assertEquals(snakeMoveValidator.isInsideOfBoardHorizontal(192), false);
    }

    @Test
    public void shouldSnakeMoveWhenConflictOnNextMove() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        snake.addHead();
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        snake.setHead(new Point(10, 15));
        snake.addHead();

        // then
        assertEquals(snakeMoveValidator.isNextFieldEmpty(-10, -15), false);
    }

    @Test
    public void shouldSnakeMoveWhenNextFieldIsEmpty() {
        // given
        Snake snake = new Snake(lengthOfSnake);
        SnakeMoveValidator snakeMoveValidator = new SnakeMoveValidator(snake);

        // when
        snake.setHead(new Point(2, 2));
        snake.addHead();

        // then
        assertEquals(snakeMoveValidator.isNextFieldEmpty(1, 1), true);
    }
}
