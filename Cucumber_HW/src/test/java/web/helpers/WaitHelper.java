package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
    private static Logger logger = LogManager.getLogger(WaitHelper.class);
    protected static WebDriverWait webDriverWait;

    public static void init(WebDriver driver, Duration timeOut, Duration sleep) {
        webDriverWait = new WebDriverWait(driver, timeOut, sleep);
    }

    public static void clickabilityOfElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void visibilityOf(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void visibilityOfAllElements(List <WebElement> webElements){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}