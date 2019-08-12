package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class DDTLoginTest {

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(LoginPage.URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @ParameterizedTest(name = "{index} => username={0}, password={1}")
    @ArgumentsSource(UsernamePasswordArgumentsProvider.class)
    public void testLoginWithBdd(String username, String password) {
        driver.findElement(LoginPage.LOGIN_LINK).click();
        driver.findElement(LoginPage.USERNAME).sendKeys(username);
        driver.findElement(LoginPage.PASSWORD).sendKeys(password);
        driver.findElement(LoginPage.LOGIN_BUTTON).click();
        String actual_username = driver.findElement(LoginPage.LOGGED_IN_USERNAME).getText();
        assertEquals("Selenium Test", actual_username);
    }
}
