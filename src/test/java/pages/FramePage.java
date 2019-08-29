package pages;

import org.openqa.selenium.By;

public class FramePage {

    public static final String URL = "https://the-internet.herokuapp.com/iframe";
    public static final String IFRAME_NAME = "mce_0_ifr";
    public static final By BOLD_TEXT = By.xpath("//body[@id=\"tinymce\"]/p/span/strong");
    public static final By IFRAME_BODY = By.xpath("//body[@id=\"tinymce\"]");
    public static final By BOLD_BUTTON = By.xpath("//i[@class=\"mce-ico mce-i-bold\"]");
}
