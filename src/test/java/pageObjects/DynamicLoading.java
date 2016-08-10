package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends Base {

    private WebDriver driver;

    By startButton = By.cssSelector("#start button");
    By finishText = By.id("finish");

    public DynamicLoading (WebDriver driver) {
        super(driver);
    }

    public void loadExample(String exampleNumber) {
        visit("http://the-internet.herokuapp.com/dynamic_loading/" + exampleNumber);
        click(startButton);
    }

    public Boolean finishTextPresent() {
        return waitForIsDisplayed(finishText, 10);
    }

}
