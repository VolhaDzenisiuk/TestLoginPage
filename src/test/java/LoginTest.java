import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(LoginPage.URL);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login() {
        driver.findElement(LoginPage.LOGIN_LINK).click();
        driver.findElement(LoginPage.USERNAME).sendKeys("seleniumtests@tut.by");
        driver.findElement(LoginPage.PASSWORD).sendKeys("123456789zxcvbn");
        driver.findElement(LoginPage.LOGIN_BUTTON).click();
        String actual_username = driver.findElement(LoginPage.LOGGED_IN_USERNAME).getText();
        assertEquals("Selenium Test", actual_username, "Expected username doesn't match actual.");
    }
}
