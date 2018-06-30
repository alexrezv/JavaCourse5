import Week3.model.impl.EfficientRater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EfficientRaterTest {
    @Test
    public void testGetRatingCatchesNPE() {
        EfficientRater classUnderTest = new EfficientRater();
        assertEquals(classUnderTest.getRating(""), -1, 0.0);
    }
}
