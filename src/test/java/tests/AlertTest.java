package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AlertPage;

import static org.junit.Assert.assertEquals;

public class AlertTest {

    private WebDriver driver;
    private WebElement message;

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(AlertPage.URL);
        message = driver.findElement(AlertPage.RESULT);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void testJsAlert() {
        WebElement jsAlert = driver.findElement(AlertPage.JS_ALERT);
        jsAlert.click();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            assertEquals("Expected and actual JS alerts don't match", "You successfuly clicked an alert", message.getText());
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsConfirm() {
        WebElement jsConfirm = driver.findElement(AlertPage.JS_CONFIRM);
        jsConfirm.click();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            assertEquals("Expected and actual JS confirm alerts don't match", "You clicked: Ok", message.getText());
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJsPrompt() {
    	String text = "alert test";
        WebElement jsPrompt = driver.findElement(AlertPage.JS_PROMPT);
        jsPrompt.click();
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
            assertEquals("Expected and actual JS prompt alerts don't match", "You entered: " + text, message.getText());
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}
