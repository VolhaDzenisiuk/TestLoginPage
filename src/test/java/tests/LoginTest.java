package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.get(LoginPage.URL);
        driver.manage().window().maximize();
        Thread.sleep(5000); //implicit wait
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void login() throws IOException {
        final String username = "seleniumtests@tut.by";
        final String password = "123456789zxcvbn";

        driver.findElement(LoginPage.LOGIN_LINK).click();
        driver.findElement(LoginPage.USERNAME).sendKeys(username);
        driver.findElement(LoginPage.PASSWORD).sendKeys(password);
        driver.findElement(LoginPage.LOGIN_BUTTON).click();

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("Screenshots\\screenshot-test.png"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofSeconds(2));
        WebElement actual_username = wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.LOGGED_IN_USERNAME));
        assertEquals("Expected username doesn't match actual.", "Selenium Test", actual_username.getText());
    }
}
