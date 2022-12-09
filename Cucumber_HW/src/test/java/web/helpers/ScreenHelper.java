package web.helpers;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenHelper {
    private static WebDriver screener;
    private static int counter = 0;

    public static void init(WebDriver driver) {
        screener = driver;
    }

    public static void getScreen() {
        try {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(screener);
            counter++;
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screens\\Screen" + counter + ".png"));
            JavaScriptHelper.scrollTo(0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
