package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class Frames extends Base {

    @Test

    public void nestedFrames() throws Exception {

        driver.get("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        assertThat(driver.findElement(By.id("content")).getText(), is(equalTo("MIDDLE")));

    }

    @Test
    public void iFrames() throws Exception {

        driver.get("http://the-internet.herokuapp.com/tinymce");

        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();

        //assertThat(afterText, is(equalTo("Hello World!")));

        assertThat(afterText, is(not(equalTo(beforeText))));

    }
}
