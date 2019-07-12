import org.openqa.selenium.By;

class LoginPage {

    static final String URL = "https://www.tut.by/";
    static final By LOGIN_LINK = By.xpath("//a[@class='enter']");
    static final By USERNAME = By.xpath("//input[@name='login']");
    static final By PASSWORD = By.xpath("//input[@name='password']");
    static final By LOGIN_BUTTON = By.xpath("//input[@tabindex='4']");
    static final By LOGGED_IN_USERNAME = By.xpath("//span[@class='uname']");
}
