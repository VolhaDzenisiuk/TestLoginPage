package pages;

import org.openqa.selenium.By;

public class AlertPage {

    public static String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    public static By RESULT = By.xpath("//p[@id=\"result\"]");
    public static By JS_ALERT = By.xpath("//div[@class=\"example\"]/ul/li[1]/button");
    public static By JS_CONFIRM = By.xpath("//div[@class=\"example\"]/ul/li[2]/button");
    public static By JS_PROMPT = By.xpath("//div[@class=\"example\"]/ul/li[3]/button");
}
