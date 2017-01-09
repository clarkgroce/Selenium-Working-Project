package Applitools;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;

public class TestApplitools {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        Eyes eyes = new Eyes();
        eyes.setApiKey("7I5J1013VBk106ydyZ0OpwdFAr0NNDn5El798i100ZPWh6ocZk110");

        try {
            driver = eyes.open(driver, "Applitools", "Test Web Page", new RectangleSize(1024, 768));

            driver.get("http://applitools.com");

            eyes.checkWindow("Main Page");

            driver.findElement(By.cssSelector(".features>a")).click();

            eyes.checkWindow("Features page");

            eyes.close();

        } finally {
            eyes.abortIfNotClosed();
            driver.close();
        }

    }

}
