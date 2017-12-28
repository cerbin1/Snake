package snake;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {
    @Test
    public void shouldStopAfterToggleWhileRunning() {
        // when
        Application app = new Application();
        app.endGame();

        // then
        assertEquals(app.getTimer().isRunning(), false);
    }

    @Test
    public void shouldStartAfterToggleWhenStopped() {
        // when
        Application app = new Application();

        // then
        assertEquals(app.getTimer().isRunning(), true);
    }
}
