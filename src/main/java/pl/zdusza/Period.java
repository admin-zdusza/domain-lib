package pl.zdusza;

import pl.zdusza.time.Clock;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public enum Period {
    LAST_2_H(2, ChronoUnit.HOURS, ChronoUnit.MINUTES, Optional.empty()),
    LAST_2_D(2, ChronoUnit.DAYS, ChronoUnit.HOURS, Optional.empty()),
    LAST_2_M(2, ChronoUnit.MONTHS, ChronoUnit.DAYS, Optional.of(TemporalAdjusters.firstDayOfMonth())),
    LAST_12_W(12, ChronoUnit.WEEKS, ChronoUnit.WEEKS, Optional.of(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))),
    LAST_2_Y(2, ChronoUnit.YEARS, ChronoUnit.MONTHS, Optional.of(TemporalAdjusters.firstDayOfYear())),
    LAST_12_Y(12, ChronoUnit.YEARS, ChronoUnit.YEARS, Optional.of(TemporalAdjusters.firstDayOfYear()));

    private final int fromAmount;
    private final TemporalUnit fromUnit;
    private final TemporalUnit interval;
    private final Optional<TemporalAdjuster> temporalAdjuster;

    Period(final int fromAmount,
           final TemporalUnit fromUnit,
           final TemporalUnit interval,
           final Optional<TemporalAdjuster> temporalAdjuster) {
        this.fromAmount = fromAmount;
        this.fromUnit = fromUnit;
        this.interval = interval;
        this.temporalAdjuster = temporalAdjuster;
    }

    public final Instant getStart(final Clock clock) {
        ZonedDateTime zonedDateTime = clock.now().atZone(ZoneId.of("Poland"))
                .minus(this.fromAmount, this.fromUnit);
        if (temporalAdjuster.isPresent()) {
            return zonedDateTime
                    .with(this.temporalAdjuster.get())
                    .truncatedTo(ChronoUnit.DAYS)
                    .toInstant();
        }
        return zonedDateTime.truncatedTo(this.fromUnit).toInstant();
    }

    public final TemporalUnit getInterval() {
        return this.interval;
    }
}
