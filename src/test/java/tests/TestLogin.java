package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.Login;
import static org.junit.Assert.*;

public class TestLogin  {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("Success message not present", login.successMessagePresent());
    }

    @Test
    public void failed() {
        login.with("tomsmith", "badpassword");
        assertTrue("Failure message not present", login.failureMessagePresent());
    }


    @After
    public void testDown() {
        driver.quit();
    }


}
