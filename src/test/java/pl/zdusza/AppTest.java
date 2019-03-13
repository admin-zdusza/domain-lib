package pl.zdusza;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    @Test
    public final void testShouldEnumValuesEqualsEnumValues() {
        Assert.assertArrayEquals(App.values(), App.values());
    }
}
