package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        driver.switchTo().frame(FramePage.IFRAME_NAME);
		WebElement frame_body = driver.findElement(FramePage.IFRAME_BODY);
		frame_body.clear();
		frame_body.sendKeys("Hello ");
		driver.switchTo().defaultContent();

		WebElement boldButton = driver.findElement(FramePage.BOLD_BUTTON);
		boldButton.click();
		driver.switchTo().frame(FramePage.IFRAME_NAME);
		frame_body.sendKeys("world!");

		assertEquals("Hello world!", frame_body.getText().replace("\ufeff",""));
		WebElement boldText = driver.findElement(FramePage.BOLD_TEXT);
		assertEquals("700", boldText.getCssValue("font-weight"));
    }
}
