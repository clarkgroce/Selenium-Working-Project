package tests;

import org.junit.Before;
import org.junit.Test;
import pageobjects.Login;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import tests.Groups.Shallow;


public class TestLogin extends Base {

    private Login login;

    @Before
    public void setUp() {
        login = new Login(driver);
    }

    @Test
    @Category(Shallow.class)
    public void succeeded() {
        login.with("tomsmith", "SuperSecretPassword!");
        assertTrue("Success message was not displayed", login.successMessagePresent());
    }

    @Test
    @Category(Shallow.class)
    public void failed() {
        login.with("tomsmith", "bad password");
        assertTrue("Login error message not displayed", login.failureMessagePresent());
        assertFalse("Login message is displayed after bad credentials",login.successMessagePresent());
    }

    @Test
    @Category(Shallow.class)
    public void forceFailure() {
        login.with("asadfafd", "badpwd");
        assertTrue("success message wasn't present after login", login.successMessagePresent());
    }
}
