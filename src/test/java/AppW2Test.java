import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppW2Test {
    @Test
    public void testAppHasAGreeting() {
        AppW3 classUnderTest = new AppW3();
        assertNotNull("app should have a greeting",
                classUnderTest.getGreeting());
    }
}

