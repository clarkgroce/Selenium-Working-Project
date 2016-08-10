package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.DynamicLoading;
import static org.junit.Assert.*;

public class TestDynamicLoading {

    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
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

    @After
    public void tearDown() {
        driver.quit();
    }

}
