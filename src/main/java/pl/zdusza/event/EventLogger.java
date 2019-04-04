package pl.zdusza.event;

public interface EventLogger {
    void info(final LoggableEventName loggableEventName, final String context, String format, Object... replacements);

    void error(final LoggableEventName loggableEventName, final String context, String format, Object... replacements);
}
