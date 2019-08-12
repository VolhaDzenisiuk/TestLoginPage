package pages;

import org.openqa.selenium.By;

public class FramePage {

    public static final String URL = "https://the-internet.herokuapp.com/iframe";
    public static final String IFRAME_NAME = "mce_0_ifr";
    public static final By BOLD_TEXT = By.xpath("//body[@id=\"tinymce\"]/b");
    public static final By REGULAR_TEXT = By.xpath("//body[@id=\"tinymce\"]");
}
