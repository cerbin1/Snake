package snake;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;

public class AppleGeneratorTest {
    @Test
    public void shouldRelocateApple() {
        // before
        AppleGenerator appleGenerator = new AppleGenerator(new Size(10, 10));
        Point previousApplePosition = new Point(appleGenerator.getApple().x, appleGenerator.getApple().y);

        //when
        appleGenerator.relocateApple(new ArrayList<>());

        //then
        assertNotEquals(previousApplePosition, appleGenerator.getApple());
        System.out.println(previousApplePosition);
        System.out.println(appleGenerator.getApple());
    }
}