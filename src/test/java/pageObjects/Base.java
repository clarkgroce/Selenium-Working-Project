package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static tests.Config.*;

public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        if (url.contains("http")) {
            driver.get(url);
        } else {
            driver.get(baseUrl + url);
        }
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }

    public Boolean waitForIsDisplayed (By locator, Integer... timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }

        return true;
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        //in the ternary operator we say if timeout is not equal to null then it's equal to timeout, but if null
        //then timeout will be 5 seconds.  Similar to if/else statement but an easier and faster way to write it.
        timeout = timeout != null ? timeout :5;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

}
