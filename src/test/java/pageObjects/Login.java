package pageObjects;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

    By loginFormLocator = By.id("login");
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitButton = By.cssSelector("button");
    By successmessageLocator = By.cssSelector(".flash.success");
    By failuremessageLocator = By.cssSelector(".flash.error");

    public Login(WebDriver driver) {
        super(driver);
        visit("/login");
        assertTrue("The login form is not present", isDisplayed(loginFormLocator));
    }

    public void with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(submitButton);

    }

    public boolean successMessagePresent() {
       return isDisplayed(successmessageLocator);
    }

    public boolean failureMessagePresent() {
        return isDisplayed(failuremessageLocator);
    }

}
