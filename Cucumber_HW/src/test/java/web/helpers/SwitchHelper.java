package web.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class SwitchHelper {
    private static WebDriver switcher;

    public static void init(WebDriver driver) {
        switcher = driver;
    }

    public static void switchToNewWindow() {
        switcher.switchTo().newWindow(WindowType.WINDOW);
    }
}

