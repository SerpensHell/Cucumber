package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;

public class DriverHooks {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    String env = System.getProperty("browser", "chrome");
    String pageLoadStrategy = System.getProperty("loadstrategy", "normal");

    @Before
    public void startDriverBeforeScenario() {
        driver = WebDriverFactory.getDriver(env.toLowerCase(), pageLoadStrategy.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @After
    public void stopDriverAfterScenario() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
