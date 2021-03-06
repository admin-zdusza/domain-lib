package pl.zdusza.time;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pl.zdusza.event.EventLogger;
import pl.zdusza.event.LoggableEventName;

import java.time.Duration;
import java.time.Instant;

public class TimerTest {

    private static final long RESPONSE_TIME_IN_MILLIS = 1L;
    private static final long RESPONSE_TIME_ROUNDED_TO_SEC = 0L;

    private static final long HIGH_RESPONSE_TIME_IN_MILLIS = 1001L;
    private static final long HIGH_RESPONSE_TIME_ROUNDED_TO_SEC = 1L;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private EventLogger logger;

    private final Clock clock = new Clock(Instant.parse("2019-01-01T00:31:00.000Z"));

    @Test
    public final void testShouldLogTime() {
        final Timer timer = new Timer(clock, TimerTest.class.getName(), logger);
        timer.start();
        clock.setNow(Instant.parse("2019-01-01T00:31:00.001Z"));
        timer.stop();
        Mockito.verify(logger, Mockito.times(1))
                .info(LoggableEventName.RESPONSE_TIME, TimerTest.class.getName(),
                        "ms:{} roundeds:{}", RESPONSE_TIME_IN_MILLIS,
                        RESPONSE_TIME_ROUNDED_TO_SEC);
    }

    @Test
    public final void testShouldLogHighResponseTimeWhenAlertReached() {
        final Timer timer = new Timer(clock, TimerTest.class.getName(), logger, Duration.ofSeconds(1));
        timer.start();
        clock.setNow(Instant.parse("2019-01-01T00:31:01.001Z"));
        timer.stop();
        Mockito.verify(logger, Mockito.times(1))
                .error(LoggableEventName.HIGH_RESPONSE_TIME, TimerTest.class.getName(),
                        "ms:{} roundeds:{}", HIGH_RESPONSE_TIME_IN_MILLIS,
                        HIGH_RESPONSE_TIME_ROUNDED_TO_SEC);
    }
}
