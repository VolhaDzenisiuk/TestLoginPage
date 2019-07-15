import org.openqa.selenium.By;

class LoginPage {

    static final String URL = "https://www.tut.by/";
    static final By LOGIN_LINK = By.className("enter");
    static final By USERNAME = By.name("login");
    static final By PASSWORD = By.name("password");
    static final By LOGIN_BUTTON = By.xpath("//input[@tabindex='4']");
    static final By LOGGED_IN_USERNAME = By.cssSelector("span[class='uname']");
}
