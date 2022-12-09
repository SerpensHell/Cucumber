package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import web.helpers.ScreenHelper;

import java.util.List;

public class Selenium4Listener implements WebDriverListener {
    private Logger logger = LogManager.getLogger(Selenium4Listener.class);

    @Override
    public void afterClick (WebElement element) {
        logger.info("Выполнено нажатие на веб элемент");
    }

    @Override
    public void afterFindElement (WebDriver driver, By locator, WebElement element) {
        logger.info("Найден веб элемент");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Найдены веб элементы");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("Получен текст");
    }
}

