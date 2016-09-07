package tests;

import org.junit.Before;
import org.junit.Test;
import pageObjects.Login;
import static org.junit.Assert.*;

public class TestLogin extends Base {

    private Login login;


    @Before
    public void setUp() {
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
}
