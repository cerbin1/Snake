package snake;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {
    @Test
    public void shouldStopAfterToggleWhileRunning() {
        // given
        Application app;

        // when
        app = new Application();
        app.endGame();

        // then
        assertEquals(app.getTimer().isRunning(), false);
    }

    @Test
    public void shouldStartAfterToggleWhenStopped() {
        // given
        Application app;

        // when
        app = new Application();

        // then
        assertEquals(app.getTimer().isRunning(), true);
    }
}
