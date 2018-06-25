import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppW2Test {
    @Test
    public void testAppHasAGreeting() {
        AppW2 classUnderTest = new AppW2();
        assertNotNull("app should have a greeting",
                classUnderTest.getGreeting());
    }
}

