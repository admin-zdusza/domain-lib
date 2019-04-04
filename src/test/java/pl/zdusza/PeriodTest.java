package pl.zdusza;

import org.junit.Test;
import pl.zdusza.time.Clock;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    private final Clock clock = new Clock(Instant.parse("2019-01-01T00:31:00.000Z"));

    public PeriodTest() {
    }

    @Test
    public final void testShouldEvaluateLast2HStart() {
        assertEquals(Instant.parse("2018-12-31T22:00:00.000Z"), Period.LAST_2_H.getStart(clock));
    }

    @Test
    public final void testShouldEvaluateLast2DStart() {
        assertEquals(Instant.parse("2018-12-29T23:00:00.000Z"), Period.LAST_2_D.getStart(clock));
    }

    @Test
    public final void testShouldEvaluateLast2MStart() {
        assertEquals(Instant.parse("2018-10-31T23:00:00.000Z"), Period.LAST_2_M.getStart(clock));
    }

    @Test
    public final void testShouldEvaluateLast12WStart() {
        assertEquals(Instant.parse("2018-10-07T22:00:00.000Z"), Period.LAST_12_W.getStart(clock));
        assertEquals(Instant.parse("2018-10-07T22:00:00.000Z"),
                Period.LAST_12_W.getStart(new Clock(Instant.parse("2018-12-30T23:00:00.000Z"))));
    }

    @Test
    public final void testShouldEvaluateLast2YStart() {
        assertEquals(Instant.parse("2016-12-31T23:00:00.000Z"), Period.LAST_2_Y.getStart(clock));
    }

    @Test
    public final void testShouldEvaluateLast12YStart() {
        assertEquals(Instant.parse("2006-12-31T23:00:00.000Z"), Period.LAST_12_Y.getStart(clock));
    }
}

