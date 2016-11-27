package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCheckboxes extends Base {

    @Test
    public void checkboxDiscoverTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));

        System.out.println("With .attribute('checked')");
        for (WebElement checkbox : checkboxes) {
            System.out.println(String.valueOf(checkbox.getAttribute("checked")));
        }

        System.out.println("With .selected?");
        for (WebElement checkbox : checkboxes) {
            System.out.println(checkbox.isSelected());
        }
    }

    //Using the check against .attribute method
    @Test
    public void checkboxOptionalTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        assertThat(checkbox.getAttribute("checked"), is(not("null")));
        assertThat(checkbox.getAttribute("checked"), is("false"));
    }

    //Using the .isSelected method
    @Test
    public void checkboxOptionalTest2() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        assertThat(checkbox.isSelected(), is(true));
    }

    //Loop through checkboxes clicking each one, then assert on .isSelected
    @Test
    public void populateCheckboxes() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"]"));
        for (WebElement checkbox : checkboxes ) {
            checkbox.click();
        }
        WebElement checkbox2 = driver.findElement(By.cssSelector("form input:nth-of-type(1)"));
        assertThat(checkbox2.isSelected(), is(true));
    }

}
