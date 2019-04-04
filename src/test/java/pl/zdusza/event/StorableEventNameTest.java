package pl.zdusza.event;

import org.junit.Assert;
import org.junit.Test;

public class StorableEventNameTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(StorableEventName.values(), StorableEventName.values());
    }
}
