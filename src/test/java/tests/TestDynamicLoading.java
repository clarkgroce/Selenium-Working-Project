package tests;

import org.junit.Before;
import org.junit.Test;
import pageObjects.DynamicLoading;
import static org.junit.Assert.*;

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void finishTextSucceeded() {
        dynamicLoading.loadExample("1");
        assertTrue("Finish text not present", dynamicLoading.finishTextPresent());
    }

    @Test
    public void dynamicTextSucceeded() {
        dynamicLoading.loadExample("2");
        assertTrue("Finish text not present", dynamicLoading.finishTextPresent());
    }

}
