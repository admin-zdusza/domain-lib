package pl.zdusza.time;

import java.time.Instant;
import java.util.Optional;

public class Clock {

    private Optional<Instant> now;

    public Clock(final Instant now) {
        this.now = Optional.of(now);
    }

    public Clock() {
        this.now = Optional.empty();
    }

    public final Clock setNow(final Instant newNow) {
        this.now = Optional.of(newNow);
        return this;
    }

    public final Instant now() {
        return now.orElse(Instant.now());
    }
}
