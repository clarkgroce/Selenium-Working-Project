package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDropdownSelection extends Base {
    //This test is looking for the dropdown by id, and then iterating over each list option by their tag name "option"
    //and then selecting one of the options.
    @Test
    public void dropdownTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("Option 1")) {
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()) {
                selectedOption = options.get(i).getText();
            }
        }

        assertThat(selectedOption, is("Option 1"));
    }

    //This is a simpler version of the same test using a Selenium helper function called Select and selectBy method.
    @Test
    public void dropdownTestRedux() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select selectedList = new Select(driver.findElement(By.id("dropdown")));
        selectedList.selectByVisibleText("Option 1");
        assertThat(selectedList.getFirstSelectedOption().getText(), is(equalTo("Option 1")));
    }
}
