package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final String URL = "https://www.tut.by/";
    public static final By LOGIN_LINK = By.className("enter");
    public static final By USERNAME = By.name("login");
    public static final By PASSWORD = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//input[@tabindex='4']");
    public static final By LOGGED_IN_USERNAME = By.cssSelector("span[class='uname']");
}
