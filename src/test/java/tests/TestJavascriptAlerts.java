package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestJavascriptAlerts extends Base {
    //Test to generate an alert and use Selenium's Alert interface and the accept() method to accept the alert
    @Test
    public void JavascriptConfirmTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        String confirmresult = driver.findElement(By.id("result")).getText();
        assertThat(confirmresult, is(equalTo("You clicked: Ok")));
    }

    //Test to generate an alert and use Selenium's Alert interface and the dismiss() method to cancel the alert dialog
    @Test
    public void JavascriptConfirmDismissTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.dismiss();
        String confirmresult = driver.findElement(By.id("result")).getText();
        assertThat(confirmresult, is(equalTo("You clicked: Cancel")));
    }

    @Test
    public void JavascriptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(1) button")).click();
        Alert alertpopup = driver.switchTo().alert();
        //Important to note that a JS Alert only has an ok button so even if you used the dismiss() method
        //here the test would still pass because dismiss would still click ok if there is no cancel button.
        alertpopup.accept();
        String alertresult = driver.findElement(By.id("result")).getText();
        assertThat(alertresult, is(equalTo("You successfuly clicked an alert")));
    }

    //This is a test for a JS prompt and also uses the sendkeys method to enter information in the prompt
    //and then confirms that information was entered on accept.
    @Test
    public void JavascriptPromptTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector(".example li:nth-child(3) button")).click();
        Alert popup = driver.switchTo().alert();
        popup.sendKeys("I'm typing text!");
        popup.accept();
        String promptconfirm = driver.findElement(By.id("result")).getText();
        assertThat(promptconfirm, is(equalTo("You entered: I'm typing text!")));
    }

}
