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
import java.util.ArrayList;
import java.util.List;
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

    private ZonedDateTime getStart(final ZonedDateTime now) {
        final ZonedDateTime zonedDateTime = now.minus(this.fromAmount, this.fromUnit);
        if (temporalAdjuster.isPresent()) {
            return zonedDateTime
                    .with(this.temporalAdjuster.get())
                    .truncatedTo(ChronoUnit.DAYS);
        }
        return zonedDateTime.truncatedTo(this.fromUnit);
    }

    public final Instant getStart(final Clock clock) {
        return getStart(clock.now().atZone(ZoneId.of("Poland"))).toInstant();
    }

    public final List<Instant> getDates(final Clock clock) {
        final ZonedDateTime now = clock.now().atZone(ZoneId.of("Poland"));
        final List<Instant> dates = new ArrayList<>();
        ZonedDateTime date = getStart(now);
        while (date.toInstant().isBefore(now.toInstant())) {
            dates.add(date.toInstant());
            date = date.plus(1, interval);
        }
        if (date.equals(now)) {
            dates.add(date.toInstant());
        }
        return dates;
    }
}
