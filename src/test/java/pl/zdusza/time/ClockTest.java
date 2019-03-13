package pl.zdusza.time;

import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClockTest {

    @Test
    public final void testShouldReturnNowByDefault() {
        assertTrue(new Clock().now().minusNanos(1).isBefore(Instant.now()));
    }

    @Test
    public final void testShouldReturnSetNow() {
        final Instant now = Instant.now();
        assertEquals(now, new Clock(now).now());
        assertEquals(now, new Clock().setNow(now).now());
    }
}
