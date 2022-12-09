package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {
    private static Logger logger = LogManager.getLogger(WindowHelper.class);
    private static WebDriver window;

    public static void init(WebDriver driver) {
        window = driver;
    }

    public static void maximizeWindow() {
        window.manage().window().maximize();
    }

    public static void windowWidth() {
        logger.info(String.format("Ширина окна: %d", window.manage().window().getSize().getWidth()));
    }

    public static void windowHeight() {
        logger.info(String.format("Высота окна: %d", window.manage().window().getSize().getHeight()));
    }
}
