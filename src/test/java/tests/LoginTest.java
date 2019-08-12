package tests;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(LoginPage.URL);
        driver.manage().window().maximize();
        Thread.sleep(5000); //implicit wait
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login() {
        final String username = "seleniumtests@tut.by";
        final String password = "123456789zxcvbn";

        driver.findElement(LoginPage.LOGIN_LINK).click();
        driver.findElement(LoginPage.USERNAME).sendKeys(username);
        driver.findElement(LoginPage.PASSWORD).sendKeys(password);
        driver.findElement(LoginPage.LOGIN_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofSeconds(2));
        WebElement actual_username = wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.LOGGED_IN_USERNAME));
        assertEquals("Selenium Test", actual_username.getText(), "Expected username doesn't match actual.");
    }
}
