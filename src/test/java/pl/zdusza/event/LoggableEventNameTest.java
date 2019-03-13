package pl.zdusza.event;

import org.junit.Assert;
import org.junit.Test;

public class LoggableEventNameTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(LoggableEventName.values(), LoggableEventName.values());
    }
}
