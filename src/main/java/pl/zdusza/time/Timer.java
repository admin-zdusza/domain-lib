package pl.zdusza.time;

import pl.zdusza.event.EventLogger;
import pl.zdusza.event.LoggableEventName;

import java.time.Duration;

public class Timer {

    private static final int MILLIS_IN_SECOND = 1000;

    private final Clock clock;

    private final String context;

    private final EventLogger logger;

    private final Duration alertThreshold;

    private long start;

    public Timer(final Clock clock, final String context, final EventLogger logger,
                 final Duration alertThreshold) {
        this.clock = clock;
        this.context = context;
        this.logger = logger;
        this.alertThreshold = alertThreshold;
    }

    public Timer(final Clock clock, final String context, final EventLogger logger) {
        this(clock, context, logger, Duration.ofSeconds(1));
    }

    public final void start() {
        this.start = clock.now().toEpochMilli();
    }

    public final void stop() {
        final long duration = clock.now().toEpochMilli() - start;
        if (duration <= alertThreshold.toMillis()) {
            logger.info(LoggableEventName.RESPONSE_TIME, context, "ms:{} roundeds:{}", duration,
                    toSeconds(duration));
        } else {
            logger.error(
                    LoggableEventName.HIGH_RESPONSE_TIME, context, "ms:{} roundeds:{}", duration,
                    toSeconds(duration));
        }
    }

    private long toSeconds(final long durationInMillis) {
        return durationInMillis / MILLIS_IN_SECOND;
    }
}
