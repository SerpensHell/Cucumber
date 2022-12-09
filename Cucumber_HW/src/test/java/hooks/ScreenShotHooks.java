package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.JavascriptExecutor;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class ScreenShotHooks {
   protected static JavascriptExecutor javascriptExecutor;

    @BeforeStep
    public void takeScreenShotBeforeStep() {
        javascriptExecutor = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
        String script = "window.scrollTo(0,0);";

        try {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(WebDriverFactory.getCurrentDriver());
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screens\\Screen" + Timestamp.from(Instant.now()).getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        javascriptExecutor.executeScript(script);
    }

    @AfterStep
    public void takeScreenShotAfterStep() {
        javascriptExecutor = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
        String script = "window.scrollTo(0,0);";
        try {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(WebDriverFactory.getCurrentDriver());
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\Screens\\Screen" + Timestamp.from(Instant.now()).getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        javascriptExecutor.executeScript(script);
    }

}
