package pl.zdusza.time;

import org.slf4j.Logger;
import pl.zdusza.event.LoggableEventName;

import java.time.Duration;

public class Timer {

    private static final int MILLIS_IN_SECOND = 1000;

    private final Clock clock;

    private final String context;

    private final Logger logger;

    private final Duration alertThreshold;

    private long start;


    public Timer(final Clock clock, final String context, final Logger logger,
                 final Duration alertThreshold) {
        this.clock = clock;
        this.context = context;
        this.logger = logger;
        this.alertThreshold = alertThreshold;
    }

    public Timer(final Clock clock, final String context, final Logger logger) {
        this(clock, context, logger, Duration.ofSeconds(1));
    }

    public final void start() {
        this.start = clock.now().toEpochMilli();
    }

    public final void stop() {
        final long duration = clock.now().toEpochMilli() - start;
        if (duration <= alertThreshold.toMillis()) {
            logger.info("{} ms:{} roundeds:{} context:{}",
                    LoggableEventName.RESPONSE_TIME,
                    duration,
                    toSeconds(duration),
                    context);
        } else {
            logger.error("{} ms:{} roundeds:{} context:{}",
                    LoggableEventName.HIGH_RESPONSE_TIME,
                    duration,
                    toSeconds(duration),
                    context);
        }
    }

    private long toSeconds(final long durationInMillis) {
        return durationInMillis / MILLIS_IN_SECOND;
    }
}
