package pages;

import org.openqa.selenium.By;

public class AlertPage {

    public static String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    public static By RESULT = By.xpath("//p[@id=\"result\"]");
    public static By JS_ALERT = By.xpath("//button[@onclick=\"jsAlert()\"]");
    public static By JS_CONFIRM = By.xpath("//button[@onclick=\"jsConfirm()\"]");
    public static By JS_PROMPT = By.xpath("//button[@onclick=\"jsPrompt()\"]");
}
