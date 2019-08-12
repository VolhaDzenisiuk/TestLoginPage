package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FramePage;

import static org.junit.Assert.assertEquals;

public class FrameTest {

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(FramePage.URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void testFrame() {
        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.setContent('')");
        ((JavascriptExecutor)driver).executeScript("tinyMCE.activeEditor.selection.setContent('Hello <b>world!</b>')");
        driver.switchTo().frame(FramePage.IFRAME_NAME);
        WebElement regularText = driver.findElement(FramePage.REGULAR_TEXT);
        assertEquals("Hello world!", regularText.getText());

        WebElement boldText = driver.findElement(FramePage.BOLD_TEXT);
        assertEquals("700", boldText.getCssValue("font-weight"));
    }
}
