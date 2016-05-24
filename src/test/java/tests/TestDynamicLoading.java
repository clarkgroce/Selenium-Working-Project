package tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import pageobjects.DynamicLoading;
import org.junit.experimental.categories.Category;
import tests.Groups.Deep;

@Category(Deep.class)

public class TestDynamicLoading extends Base {

    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        dynamicLoading = new DynamicLoading(driver);
    }

    @Test
    public void hiddenElementLoads() {
        dynamicLoading.loadExample("1");
        assertTrue("finish text didn't display after loading",
                dynamicLoading.finishTextPresent());
    }

    @Test
        public void elementAppears() {
        dynamicLoading.loadExample("2");
        assertTrue("finish text was not displayed after loading",
                dynamicLoading.finishTextPresent());
    }
}

