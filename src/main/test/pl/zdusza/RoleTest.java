package pl.zdusza;

import org.junit.Assert;
import org.junit.Test;

public class RoleTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(Role.values(), Role.values());
    }
}
