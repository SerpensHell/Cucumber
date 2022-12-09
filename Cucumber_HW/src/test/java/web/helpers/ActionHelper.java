package web.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
    protected static Actions actions;

    public static void init(WebDriver driver) {
        actions = new Actions(driver);
    }

    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }
}

