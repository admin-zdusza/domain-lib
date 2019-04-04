package pl.zdusza;

import org.junit.Assert;
import org.junit.Test;

public class DeviceTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(Device.values(), Device.values());
    }
}
