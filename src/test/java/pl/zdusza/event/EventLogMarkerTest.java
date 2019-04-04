package pl.zdusza.event;

import org.junit.Assert;
import org.junit.Test;

public class EventLogMarkerTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(EventLogMarker.values(), EventLogMarker.values());
    }
}
